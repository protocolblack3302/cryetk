package com.example.springdemo.demo.messaging;

import com.example.springdemo.demo.domains.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Service
public class JMSOrderMessagingService {

    private JmsTemplate jmsTemplate;


    public JMSOrderMessagingService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendOrder(Order order){
        jmsTemplate.send(session -> session.createObjectMessage(order));
    }

}
