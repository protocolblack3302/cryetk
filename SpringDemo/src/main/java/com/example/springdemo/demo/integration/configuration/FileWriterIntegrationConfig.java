////java configuration for file writing integration flow to integreate channels with gateways
//
//package com.example.springdemo.demo.integration.configuration;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.annotation.ServiceActivator;
//import org.springframework.integration.annotation.Transformer;
//import org.springframework.integration.channel.DirectChannel;
//import org.springframework.integration.file.FileWritingMessageHandler;
//import org.springframework.integration.file.support.FileExistsMode;
//import org.springframework.integration.transformer.GenericTransformer;
//import org.springframework.messaging.MessageChannel;
//
//import java.io.File;
//
//@Configuration
//public class FileWriterIntegrationConfig {
//
//@Bean
//    @Transformer(inputChannel = "textInChannel",outputChannel = "textWriterChannel")
//    public GenericTransformer<String,String> upperCaseTransformer(){
//       return String::toUpperCase;
//}
//
//@Bean
//    @ServiceActivator(inputChannel = "textWriterChannel")
//    public FileWritingMessageHandler fileWriter(){
//    FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("/protocolblack/Downloads/Integeration"));
//    handler.setFileExistsMode(FileExistsMode.APPEND);
//    handler.setExpectReply(false);
//    handler.setAppendNewLine(true);
//    return handler;
//}
//
//@Bean
//    public MessageChannel textInChannel(){
//    return new DirectChannel();
//}
//    @Bean  //explicity decalring channels as beans for the fact if any other bean with same name already exists otherwise there is no need to do so
//    public MessageChannel textWriterChannel(){
//        return new DirectChannel();
//    }
//
//
//}
