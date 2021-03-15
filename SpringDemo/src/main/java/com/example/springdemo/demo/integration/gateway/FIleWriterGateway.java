//package com.example.springdemo.demo.integration.gateway;
//
//import org.springframework.integration.annotation.MessagingGateway;
//import org.springframework.integration.file.FileHeaders;
//import org.springframework.messaging.handler.annotation.Header;
//
//@MessagingGateway(defaultRequestChannel = "textInChannel")
//public interface FIleWriterGateway{
//    void writeToFile(@Header (FileHeaders.FILENAME) String filename,String data);
//}
