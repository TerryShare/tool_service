package net.xdclass.tool_service.service.impl;

import net.xdclass.tool_service.entity.User;
import net.xdclass.tool_service.repository.UserRepository;
import net.xdclass.tool_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import sun.plugin2.message.Message;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:51
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender jms;

    @Override
    public User FindByUser(String username,String password) {
        return userRepository.findUserByUsernameAndPassword(username,password);

    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String send(String sender, String receiver, String title, String text) {

        SimpleMailMessage mainMessage=new SimpleMailMessage();

        System.out.println("");
        mainMessage.setFrom(sender);
        System.out.println("");

        mainMessage.setTo(receiver);

        mainMessage.setText(text);

        jms.send(mainMessage);
        return "1";
    }


}
