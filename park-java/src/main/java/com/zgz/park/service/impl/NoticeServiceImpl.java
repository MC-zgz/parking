package com.zgz.park.service.impl;

import com.zgz.park.pojo.Notice;
import com.zgz.park.mapper.NoticeMapper;
import com.zgz.park.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统公告表 服务实现类
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

}
