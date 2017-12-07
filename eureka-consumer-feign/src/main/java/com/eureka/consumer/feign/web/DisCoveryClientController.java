package com.eureka.consumer.feign.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通过 spring cloud feign 声明式服务调用客户端
 *
 * @author: pengdh
 * @date: 2017/12/07
 */
@RestController
public class DisCoveryClientController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@GetMapping("/consumer")
	public String discovery() {
		return discoveryClient.consumer();
	}
}
