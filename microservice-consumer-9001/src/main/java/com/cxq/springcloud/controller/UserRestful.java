package com.cxq.springcloud.controller;

import com.cxq.springcloud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class UserRestful {

//    private static final String REST_URL_PREFIX = "http://localhost:8001/user/";
    private static final String REST_URL_PREFIX = "http://MICROSERVICE-PROVIDER/user/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/get/{id}")
    public User findById(@PathVariable(required = true) Integer id){
        return restTemplate.getForObject(REST_URL_PREFIX + "get/" + id ,User.class);
    }

    @RequestMapping("getAll")
    public List<User> findAll(){
        return restTemplate.getForObject(REST_URL_PREFIX + "getAll",List.class);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public User saveOrUpdate(@RequestBody User user){
        return restTemplate.postForObject(REST_URL_PREFIX + "save",user,User.class);
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        restTemplate.delete(REST_URL_PREFIX + "delete/" + id);
        return "delete successful";
    }

    //测试@EnableDiscoveryClient，消费端可以调用服务发现
    @RequestMapping(value="/serviceDiscovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/serviceDiscovery", Object.class);
    }

}
