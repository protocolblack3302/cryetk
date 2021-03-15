package com.example.springdemo.demo.messaging;


import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyListener {

    @JmsListener(destination = "myqueue")
    public void receiveMessage(String msg){
        log.info("received msg is :" + msg);
    }
}
