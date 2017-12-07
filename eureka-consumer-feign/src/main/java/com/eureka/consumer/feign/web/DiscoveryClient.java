package com.eureka.consumer.feign.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Feign 申明式接口
 *
 * @author: pengdh
 * @date: 2017/12/07
 */
@FeignClient("eureka-client")
@Component
public interface DiscoveryClient {
	@GetMapping("/dc")
	String consumer();
}
