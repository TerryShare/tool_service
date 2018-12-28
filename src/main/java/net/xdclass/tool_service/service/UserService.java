package net.xdclass.tool_service.service;

import net.xdclass.tool_service.entity.User;

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

}
