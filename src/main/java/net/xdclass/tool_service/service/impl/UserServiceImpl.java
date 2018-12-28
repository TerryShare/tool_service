package net.xdclass.tool_service.service.impl;

import net.xdclass.tool_service.entity.User;
import net.xdclass.tool_service.repository.UserRepository;
import net.xdclass.tool_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:51
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User FindByUser(String username,String password) {
        return userRepository.findUserByUsernameAndPassword(username,password);

    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }


}
