package com.eureka.client.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * discovery client
 *
 * @author: pengdh
 * @date: 2017/12/05
 */
@RestController
public class DiscoveryClientController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@GetMapping("/dc")
	public String dc() {
		String services = "Services：" + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}

	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
}
