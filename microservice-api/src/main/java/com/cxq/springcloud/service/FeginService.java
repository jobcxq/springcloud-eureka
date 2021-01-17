package com.cxq.springcloud.service;

import com.cxq.springcloud.model.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MICROSERVICE-PROVIDER",path = "/user")
public interface FeginService {

    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Integer id);// fegin的{id},必须加@PathVariable("id")

    @RequestMapping("getAll")
    public List<User> findAll();

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public User saveOrUpdate(User user);

    @RequestMapping("/delete/{id}")
    public String deleteById(Integer id);
}
