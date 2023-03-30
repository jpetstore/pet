package org.csu.petstoremanage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoremanage.domain.User;
import org.csu.petstoremanage.persistence.UserMapper;
import org.csu.petstoremanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getAccountById(String id) {
        return userMapper.selectById(id);
    }

    @Override
    public User getAccountByUsername(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userMapper.selectOne(queryWrapper);
    }
    @Override
    public void updateAccount(User user) {
        userMapper.updateById(user);
    }
    @Override
    public void resetPassword(String id, String newPassword) {
        User user = new User();
        user.setId(id);
        user.setPassword(newPassword);
        userMapper.updateById(user);
    }
    @Override
    public List<User> listUsers(){
        return userMapper.selectList(null);
    }
}
