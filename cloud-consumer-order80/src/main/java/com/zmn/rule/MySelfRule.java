package com.zmn.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fileName: MySelfRule
 *
 * @author: zhangmengnan
 * @create: 2021/6/11 13:38
 */
@Configuration
public class MySelfRule {
    @Bean
        public IRule myRule(){
        return new RandomRule();

    }
}
