package com.eureka.consumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费服务
 *
 * @author: pengdh
 * @date: 2017/12/06
 */
@RestController
public class DiscoveryController {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/consumer")
	public String discoveryClient() {
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
		System.out.println(url);
		return restTemplate.getForObject(url, String.class);
	}
}
