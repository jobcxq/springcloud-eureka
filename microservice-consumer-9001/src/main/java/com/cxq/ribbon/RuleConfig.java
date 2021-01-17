package com.cxq.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleConfig {
    @Bean
    public IRule myRule(){
//        return new RandomRule();//Ribbon默认是轮询，我自定义为随机
        return new Round5RobinRule();
    }
}
