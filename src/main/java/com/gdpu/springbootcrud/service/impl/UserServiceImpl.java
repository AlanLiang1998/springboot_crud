package com.gdpu.springbootcrud.service.impl;

import com.gdpu.springbootcrud.entity.User;
import com.gdpu.springbootcrud.mapper.UserMapper;
import com.gdpu.springbootcrud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author AlanLiang
 * @since 2020-03-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
