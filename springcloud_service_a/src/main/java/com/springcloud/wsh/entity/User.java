package com.springcloud.wsh.entity;

/**
 * @Title: User
 * @ProjectName springcloud_resttemplate
 * @Description: 用户实体类
 * @Author WeiShiHuai
 * @Date 2018/10/12 14:07
 */
public class User {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;

    public User() {

    }

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
