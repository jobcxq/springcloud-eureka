package com.cxq.springcloud.controller;

import com.cxq.springcloud.model.User;
import com.cxq.springcloud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(("/user"))
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DiscoveryClient discoveryClient;    //服务注册

    @RequestMapping("/get/{id}")
    public User findById(@PathVariable(required = true) Integer id){
        log.info("ProviderApplication8001");
        return userService.findById(id);
    }

    @RequestMapping("getAll")
    public List<User> findAll(){
        log.info("ProviderApplication8001");
        return userService.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public User saveOrUpdate(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        userService.deleteById(id);
        return "delete successful";
    }

    @RequestMapping(value = "/serviceDiscovery", method = RequestMethod.GET)
    public Object serviceDiscovery(){
        List<String> list = discoveryClient.getServices();
        List<ServiceInstance> ServiceList = discoveryClient.getInstances("MICROSERVICE-PROVIDER");
        for (ServiceInstance element : ServiceList) {
            log.info(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return discoveryClient;
    }

}
