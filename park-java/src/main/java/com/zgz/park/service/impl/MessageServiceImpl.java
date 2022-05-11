package com.zgz.park.service.impl;

import com.zgz.park.pojo.Message;
import com.zgz.park.mapper.MessageMapper;
import com.zgz.park.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户留言表 服务实现类
 * </p>
 *
 * @author willie
 * @since 2022-05-10
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
