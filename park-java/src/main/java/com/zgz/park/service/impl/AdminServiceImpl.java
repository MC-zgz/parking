package com.zgz.park.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zgz.park.common.handler.ParkException;
import com.zgz.park.common.utils.MD5;
import com.zgz.park.pojo.Admin;
import com.zgz.park.mapper.AdminMapper;
import com.zgz.park.pojo.VO.AdminVo;
import com.zgz.park.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 系统管理员表 服务实现类
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    /**
     * 添加管理员
     * @param adminVo
     */
    @Override
    public void insertAdmin(AdminVo adminVo) {
        String username = adminVo.getUsername();
        String password = adminVo.getPassword();

        //获取参数，验空
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            throw new ParkException(20001,"添加信息缺失！");
        }
        //验证用户名是否相同
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Integer count = baseMapper.selectCount(queryWrapper);
        if(count>0){
            throw new ParkException(20001,"用户名重复！");
        }

        //4 使用MD5加密密码
        String md5Password = MD5.encrypt(password);
        //5 补充信息后插入数据库
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(md5Password);
        admin.setAvatar("https://zgz-online-education-file.oss-cn-guangzhou.aliyuncs.com/park/default.png");
        admin.setIsDisabled(false);
        admin.setIsDeleted(false);
        baseMapper.insert(admin);

    }

    @Override
    public Admin login(Admin admin) {
        //1 获取参数，验空
        String username = admin.getUsername();
        String password = admin.getPassword();
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            throw new ParkException(20001,"用户名或密码不能为空");
        }
        //2 根据手机号获取用户信息
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Admin adminLogin = baseMapper.selectOne(queryWrapper);
        if(adminLogin==null){
            throw new ParkException(20001,"用户名或密码有误");
        }
        //3 密码加密后验证密码
        String md5Password = MD5.encrypt(password);
        if(!md5Password.equals(adminLogin.getPassword())){
            throw new ParkException(20001,"用户名或密码有误");
        }
        //验证是否为禁用状态
        Boolean isDisabled = adminLogin.getIsDisabled();
        if(isDisabled){
            throw new ParkException(20001,"该账号已被禁用！");
        }
        return adminLogin;
    }


}
