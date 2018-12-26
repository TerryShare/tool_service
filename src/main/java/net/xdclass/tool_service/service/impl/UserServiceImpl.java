package net.xdclass.tool_service.service.impl;

import net.xdclass.tool_service.entity.User;
import net.xdclass.tool_service.repository.UserRepository;
import net.xdclass.tool_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:51
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("username not found");
        }
        return userRepository.findByUsername(username);
    }
}
