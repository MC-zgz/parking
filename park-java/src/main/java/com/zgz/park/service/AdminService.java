package com.zgz.park.service;

import com.zgz.park.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zgz.park.pojo.VO.AdminVo;

/**
 * <p>
 * 系统管理员表 服务类
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
public interface AdminService extends IService<Admin> {

    void insertAdmin(AdminVo adminVo);

    Admin login(Admin admin);
}
