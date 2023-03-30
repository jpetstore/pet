package org.csu.petstoremanage.service;

import org.csu.petstoremanage.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User getAccountById(String id) ;

    public User getAccountByUsername(String username) ;

    public void updateAccount(User user);

    public void resetPassword(String id, String newPassword) ;

    public List<User> listUsers();
}
