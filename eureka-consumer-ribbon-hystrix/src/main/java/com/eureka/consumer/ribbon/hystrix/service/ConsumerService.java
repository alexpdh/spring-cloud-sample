package com.eureka.consumer.ribbon.hystrix.service;

/**
 * 消费者service
 *
 * @author pengdh
 * @date 2018/01/17
 */

public interface ConsumerService {

	/**
	 * 消费方法
	 *
	 * @return String
	 */
	String consumer();
}
