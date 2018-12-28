package net.xdclass.tool_service.repository;

import net.xdclass.tool_service.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:53
 */
public interface UserRepository extends CrudRepository<User ,Long> {

    /**
     * 根据用户名查找用户
     * 登录
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String username,String password);
}
