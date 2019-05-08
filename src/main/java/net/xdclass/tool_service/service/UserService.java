package net.xdclass.tool_service.service;

import net.xdclass.tool_service.entity.User;
import net.xdclass.tool_service.util.NoteUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:49
 */
public interface UserService {


    /**
     * 根据用户姓名查尋用戶
     * @param username
     * @return
     */
    User FindByUser(String username,String password);

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 发送邮件
     * @param sender
     * @param receiver
     * @param title
     * @param text
     * @return
     */
     String send(String sender,String receiver,String title,String text);

    /**
     * 发送短信
     * @param apikey
     * @param text
     * @param mobile
     * @return
     * @throws IOException
     */
     NoteUtil note(String apikey, String text, String mobile) throws IOException, URISyntaxException;

     NoteUtil notes(String apikey, long tpl_id, String codes, String mobile) throws IOException, URISyntaxException;

    /**
     * 分页or模糊查询
     * @param username
     * @param pageable
     * @return
     */
     Page<User> listUserByNameLike(String username , Pageable pageable);



}
