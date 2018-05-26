package com.lisang.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 * RabbitAutoConfiguration
 * 自动连接工厂：ConnectionFactory
 * RabbitProperties封装了RabbitMQ的配置
 * RabbitTemplate给RabbitMQ发送消息
 * AmqpAdmin 系统管理组件 AmqpAdmin创建和删除
 *
 */
@EnableRabbit
@SpringBootApplication
public class SpringbootRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRabbitmqApplication.class, args);
	}
}
