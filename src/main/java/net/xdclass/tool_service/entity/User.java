package net.xdclass.tool_service.entity;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


/**
 * Greated by Terry on 2018/12/26
 * Time: 10:26
 */
@Entity(name = "user") //实体
public class User  {

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


    public boolean isAccountNonExpired() {
        return false;
    }


    public boolean isAccountNonLocked() {
        return false;
    }


    public boolean isCredentialsNonExpired() {
        return false;
    }


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
    public User(){}

    public  User(int id,String username,String email,String password,int code){
        this.id=id;
        this.username=username;
        this.password=password;
        this.email=email;
        this.code=code;
    }



}
