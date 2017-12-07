package com.eureka.consumer.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费服务(ribbon)
 *
 * @author: pengdh
 * @date: 2017/12/07
 */
@RestController
public class DiscoveryClientController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/consumer")
	public String discovery() {
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}
}
