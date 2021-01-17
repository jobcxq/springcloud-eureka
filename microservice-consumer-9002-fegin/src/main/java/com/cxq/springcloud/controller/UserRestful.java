package com.cxq.springcloud.controller;

import com.cxq.springcloud.model.User;
import com.cxq.springcloud.service.FeginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer")
public class UserRestful {

    @Autowired
    FeginService feginService;

    @RequestMapping("/get/{id}")
    public User findById(@PathVariable(name = "id") Integer id){
        return feginService.findById(id);
    }

    @RequestMapping("getAll")
    public List<User> findAll(){
        return feginService.findAll();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public User saveOrUpdate(@RequestBody User user){
        return feginService.saveOrUpdate(user);
    }

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        feginService.deleteById(id);
        return "delete successful";
    }

}
