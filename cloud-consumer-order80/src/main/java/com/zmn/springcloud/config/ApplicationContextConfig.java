package com.zmn.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * fileName: ApplicationContectConfig
 *
 * @author: zhangmengnan
 * @create: 2021/6/10 0:46
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced  //负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
