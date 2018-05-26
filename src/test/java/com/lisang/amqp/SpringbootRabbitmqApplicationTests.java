package com.lisang.amqp;

import com.lisang.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRabbitmqApplicationTests {
	@Autowired
	RabbitTemplate rabbitTemplate;
	@Autowired
	AmqpAdmin amqpAdmin;
	@Test
	public void createExchange(){
		//amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		//amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
		//amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amap.lisang",null));
	}
	/**
	 * (点对点)
	 */
	@Test
	public void contextLoads() {
		//message需要自己构造；定义消息体内容和消息头
		//rabbitTemplate.send(exchange,routeKey,message);

		//只需要传入的发送的对象，自动序列化发送给rabbitmq
		//rabbitTemplate.convertAndSend(exchange,routeKey,message);
		Map<String,Object> map = new HashMap<>();
		map.put("msg","消息");
		map.put("date", Arrays.asList("hello lisang",123,true));
		//对象默认序列化后发送出去
		rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",new Book("西游记","吴承恩"));
	}
	//将数据转换成json
	@Test
	public void receive(){
		Object o=rabbitTemplate.receiveAndConvert("atguigu.news");
		System.out.println(o.getClass());
		System.out.println(o.toString());
	}
	/**
	 * 广播(不需要管路由器）
	 */
	@Test
	public void sendMsg(){
		rabbitTemplate.convertAndSend("exchange.fanout","",new Book("大话西游","周星驰"));
	}
}
