package com.springcloud.wsh.controller;

import com.springcloud.wsh.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Title: ServiceBController
 * @ProjectName springcloud_resttemplate
 * @Description: 测试Controller
 * @Author WeiShiHuai
 * @Date 2018/10/12 14:06
 */
@RestController
public class ServiceBController {

    //模拟数据
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(UUID.randomUUID().toString(), "zhangsan", "123456"));
        userList.add(new User(UUID.randomUUID().toString(), "lisi", "654321"));
        userList.add(new User(UUID.randomUUID().toString(), "wangwu", "wang123456"));
    }

    @RequestMapping("/getUserList")
    public List<User> getUserList() {
        return userList;
    }

    @RequestMapping("/getByUserId")
    public User getByUserId(String id) {
        return userList.get(Integer.parseInt(id));
    }

    @RequestMapping("/saveUser")
    public String saveUser(@RequestBody User user) {
        return "save success! >>>" + user.toString();
    }

    @RequestMapping("/saveUserAndType")
    public String saveUserAndType(@RequestBody User user, String type) {
        return "save success! >>>" + user.toString() + ", type >>>" + type;
    }

    @RequestMapping("/postByMap")
    public String postByMap(String name) {
        return "name >>> " + name;
    }

}
