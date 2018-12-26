package net.xdclass.tool_service.service;

import net.xdclass.tool_service.entity.User;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:49
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     * @return
     */
    User registerUser(User user);

}
