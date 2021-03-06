package com.eureka.consumer.ribbon.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费实现类
 *
 * @author pengdh
 * @date 2018/01/17
 */
@Service
public class DefaultConsumerService implements ConsumerService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	@Override
	public String consumer() {
		return restTemplate.getForObject("http://eureka-client/dc", String.class);
	}

	public String fallback() {
		return "fallback";
	}
}
