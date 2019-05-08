package net.xdclass.tool_service.service.impl;

import net.xdclass.tool_service.entity.User;
import net.xdclass.tool_service.repository.UserRepository;
import net.xdclass.tool_service.service.UserService;
import net.xdclass.tool_service.util.NoteUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;

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

    /**
     * 发送邮件
     * @param sender
     * @param receiver
     * @param title
     * @param text
     * @return
     */
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

    /**
     * 发送短信实现
     * @param apikey key
     * @param text  短信内容
     * @param mobile 接收的手机
     * @return
     * @throws IOException
     */
    @Override
    public NoteUtil note(String apikey, String text, String mobile) throws IOException, URISyntaxException {
        NoteUtil note=new NoteUtil();
        note.sendSms(apikey,text,mobile);
        return note;
    }

    @Override
    public NoteUtil notes(String apikey, long tpl_id , String codes, String mobile) throws IOException, URISyntaxException {
        NoteUtil note=new NoteUtil();
        note.tplSendSms(apikey,tpl_id,codes,mobile);
        return note;
    }


    @Override
    public Page<User> listUserByNameLike(String username, Pageable pageable) {
        //模糊查询
        username="%"+username+"%";
        Page<User> users=userRepository.findByUsernameLike(username,pageable);
        return users;
    }


}
