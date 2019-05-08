package net.xdclass.tool_service.repository;

import net.xdclass.tool_service.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:53
 */
public interface UserRepository extends CrudRepository<User ,Long>  {

    /**
     * 根据用户名查找用户
     * 登录
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 登录
     * @param username 用户的账户
     * @param password 用户密码
     * @return
     */
    User findUserByUsernameAndPassword(String username,String password);

    /**
     * 分页
     * @param username
     * @param pageable
     * @return
     */
    Page<User> findByUsernameLike(String username, Pageable pageable);

}
