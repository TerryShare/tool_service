package net.xdclass.tool_service.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Greated by Terry on 2018/12/26
 * Time: 10:26
 */
@Entity //实体
public class User implements UserDetails {

    private static  final  long serialVersionUID = 1L;

    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增策略
    @Size(max = 11)
    private int id; //实体唯一标识

    @Size(min = 2,max = 20)
    @Column(nullable = false ,length = 20)//映射字段
    private String username; //用户名

    @Size(max = 20)
    @Email(message = "邮箱格式不对")
    @Column(nullable = false ,length = 20, unique = true)//映射字段
    private String email; //用户邮箱

    @Size(max = 100)
    @Column(length = 100)
    private String password; //账户密码

    @Size(max = 1)
    @Column(length = 1)
    private int code;//账户状态  0 未激活  1 已激活

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    //无参构造 , 已protected修饰 防止直接使用
    protected  User(){}

    public  User(int id,String username,String email,String password,int code){
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.code=code;
    }

    /**
     * 加密密码
     *
     * @param password
     */
    public void setEncodePassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePasswd = encoder.encode(password);
        this.password = encodePasswd;
    }

    /**
     * 抓取用户列表
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        return simpleAuthorities;
    }

}
