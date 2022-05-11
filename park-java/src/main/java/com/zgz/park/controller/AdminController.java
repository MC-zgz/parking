package com.zgz.park.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zgz.park.common.config.Result;
import com.zgz.park.common.handler.ParkException;
import com.zgz.park.common.utils.MD5;
import com.zgz.park.pojo.Admin;
import com.zgz.park.pojo.VO.AdminVo;
import com.zgz.park.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 系统管理员表 前端控制器
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Api(description = "管理员")
@CrossOrigin
@RestController
@RequestMapping("/park/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 添加管理员
     * @param adminVo
     * @return
     */
    @ApiOperation("添加管理员")
    @PostMapping("/insertAdmin")
    public Result insertAdmin(AdminVo adminVo){
        adminService.insertAdmin(adminVo);
        return Result.succ();
    }

    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    @ApiOperation("根据id删除管理员")
    @DeleteMapping("/deleteAdminById/{id}")
    public Result deleteAdminById(@PathVariable String id){
        boolean remove = adminService.removeById(id);
        if(remove) {
            return Result.succ();
        }else {
            return Result.error();
        }
    }

    /**
     *
     * @param current 当前页数
     * @param limit 每页显示几条
     * @return
     */
    @ApiOperation("分页查询管理员信息")
    @GetMapping("/getAdminByPage/{current}/{limit}")
    public Result getAdminByPage(@PathVariable Long current,@PathVariable Long limit){

        Page<Admin> page = new Page<>(current, limit);
        adminService.page(page,null);
        List<Admin> records = page.getRecords();//获取数据
        Long total = page.getTotal();//共有几条
        //存入map
        Map<String,Object> map = new HashMap<>();
        map.put("records",records);
        map.put("total",total);
        return Result.succ().data(map);
    }


    /**
     * 根据id查询管理员信息
     * @param id
     * @return
     */
    @ApiOperation("根据id查询管理员信息")
    @GetMapping("/getAdminInfoById/{id}")
    public Result getAdminInfoById(@PathVariable String id){
        Admin admin = adminService.getById(id);
        return Result.succ().data("admin",admin);
    }

    /**
     * 根据id修改管理员信息
     * @param admin
     * @return
     */
    @ApiOperation("根据id修改管理员信息")
    @PostMapping("/updateAdminById")
    public Result updateAdminById(@RequestBody Admin admin){
        //4 使用MD5加密密码
        String md5Password = MD5.encrypt(admin.getPassword());
        admin.setPassword(md5Password);
        boolean update = adminService.updateById(admin);
        if(update){
            return Result.succ();
        }else {
            return Result.error();
        }

    }

    /**
     * 后台管理员登录
     * @param admin
     * @return
     */
    @ApiOperation("管理员登录")
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){
        Admin adminLogin = adminService.login(admin);
        return Result.succ().data("admin",adminLogin);
    }




}

