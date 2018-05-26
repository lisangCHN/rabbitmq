package com.lisang.amqp.service;

import com.lisang.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Create by lisang on 2018/5/22.
 */
@Service
public class BookService {
    @RabbitListener(queues = "atguigu.news")
    public void revice(Book book){
        System.out.println("收到消息："+book.toString());
    }
    @RabbitListener(queues = "atguigu")
    public void revice2(Message message){
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
