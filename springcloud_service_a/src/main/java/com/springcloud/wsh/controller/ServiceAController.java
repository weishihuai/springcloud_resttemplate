package com.springcloud.wsh.controller;

import com.springcloud.wsh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Title: ServiceAController
 * @ProjectName springcloud_resttemplate
 * @Description: RestTemplate的使用方法
 * @Author WeiShiHuai
 * @Date 2018/10/12 13:55
 */
@RestController
public class ServiceAController {

    @Autowired
    private RestTemplate restTemplate;

    /*********************************************getForEntity****************************************************/

    /**
     * 无参数情况下的getForEntity
     */
    @RequestMapping("/getUserList")
    public String getUserList() {
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("http://service-b/getUserList", List.class);
        List<User> list = responseEntity.getBody();
        return list.toString();
    }

    /**
     * 有参数情况下的getForEntity
     * 传参方式1: 使用占位符方式
     */
    @RequestMapping("/getByUserId")
    public String getByUserId(String id) {
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity("http://service-b/getByUserId?id={id}", User.class, id);
        User userBody = userResponseEntity.getBody();
        return userBody.toString();
    }

    /**
     * 有参数情况下的getForEntity
     * 传参方式1: 使用map方式
     */
    @RequestMapping("/getByUserIdByMap")
    public String getByUserIdByMap(String id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity("http://service-b/getByUserId?id={id}", User.class, paramMap);
        User userBody = userResponseEntity.getBody();
        return userBody.toString();
    }


    /*********************************************getForObject****************************************************/

    /**
     * 无参数情况下的getForObject
     */
    @RequestMapping("/getUserList2")
    public String getUserList2() {
        //直接使用getForObject，就不用使用getBody()方法再转一次
        List userList = restTemplate.getForObject("http://service-b/getUserList", List.class);
        return userList.toString();
    }

    /**
     * 有参数情况下的getForObject
     * 传参方式1: 使用占位符方式
     */
    @RequestMapping("/getByUserId2")
    public String getByUserId2(String id) {
        //直接使用getForObject，就不用使用getBody()方法再转一次，直接就是User对象
        User user = restTemplate.getForObject("http://service-b/getByUserId?id={id}", User.class, id);
        return user.toString();
    }

    /**
     * 有参数情况下的getForObject
     * 传参方式1: 使用map方式
     */
    @RequestMapping("/getByUserIdByMap2")
    public String getByUserIdByMap2(String id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        //直接使用getForObject，就不用使用getBody()方法再转一次，直接就是User对象
        User user = restTemplate.getForObject("http://service-b/getByUserId?id={id}", User.class, paramMap);
        return user.toString();
    }

    /*********************************************postForEntity****************************************************/

    /**
     * 无参数情况下的postForEntity
     */
    @RequestMapping("/saveUser")
    public String saveUser() {
        User user = new User(UUID.randomUUID().toString(), "zhaoliu", "123");
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://service-b/saveUser", user, String.class);
        return stringResponseEntity.getBody();
    }

    /**
     * 有参数情况下的postForEntity
     * 传参方式1: 使用占位符方式
     */
    @RequestMapping("/saveUserAndType")
    public String saveUserAndType(String type) {
        User user = new User(UUID.randomUUID().toString(), "zhaoliu", "123");
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://service-b/saveUserAndType?type={type}", user, String.class, type);
        return stringResponseEntity.getBody();
    }


    /**
     * 有参数情况下的postForEntity
     * 传参方式2: 使用map方式
     */
    @RequestMapping("/saveUserAndTypeMap")
    public String saveUserAndTypeMap(String type) {
        User user = new User(UUID.randomUUID().toString(), "zhaoliu", "123");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://service-b/saveUserAndType?type={type}", user, String.class, paramMap);
        return stringResponseEntity.getBody();
    }

    /*********************************************postForObject****************************************************/

    /**
     * 无参数情况下的postForObject
     */
    @RequestMapping("/saveUser2")
    public String saveUser2() {
        User user = new User(UUID.randomUUID().toString(), "zhaoliu", "123");
        return restTemplate.postForObject("http://service-b/saveUser", user, String.class);
    }

    /**
     * 有参数情况下的postForObject
     * 传参方式1: 使用占位符方式
     */
    @RequestMapping("/saveUserAndType2")
    public String saveUserAndType2(String type) {
        User user = new User(UUID.randomUUID().toString(), "zhaoliu", "123");
        return restTemplate.postForObject("http://service-b/saveUserAndType?type={type}", user, String.class, type);
    }

    /**
     * 有参数情况下的postForObject
     * 传参方式2: 使用map方式
     */
    @RequestMapping("/saveUserAndTypeMap2")
    public String saveUserAndTypeMap2(String type) {
        User user = new User(UUID.randomUUID().toString(), "zhaoliu", "123");
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("type", type);
        return restTemplate.postForObject("http://service-b/saveUserAndType?type={type}", user, String.class, paramMap);
    }

    /*********************************************post方式传参数注意点****************************************************/

    @RequestMapping("/postByMap")
    public String postByMap(String name) {
        //使用post方式传递参数不能使用map,后台接收不到参数，要使用MultiValueMap
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return restTemplate.postForObject("http://service-b/postByMap", paramMap, String.class);
    }

    @RequestMapping("/postByMultiValueMap")
    public String post(String name) {
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("name", name);
        return restTemplate.postForObject("http://service-b/postByMap", paramMap, String.class);
    }

}
