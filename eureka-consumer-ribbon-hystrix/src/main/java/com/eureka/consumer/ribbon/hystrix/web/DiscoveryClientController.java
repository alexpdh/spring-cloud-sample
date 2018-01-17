package com.eureka.consumer.ribbon.hystrix.web;

import com.eureka.consumer.ribbon.hystrix.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hystrix服务降级
 *
 * @author pengdh
 * @date 2018/01/17
 */
@RestController
public class DiscoveryClientController {

	@Autowired
	private ConsumerService consumerService;

	@GetMapping("/consumer")
	public String dc() {
		return consumerService.consumer();
	}
}
