package com.zgz.park.service.impl;

import com.zgz.park.pojo.OrderInfo;
import com.zgz.park.mapper.OrderInfoMapper;
import com.zgz.park.service.OrderInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo> implements OrderInfoService {

}
