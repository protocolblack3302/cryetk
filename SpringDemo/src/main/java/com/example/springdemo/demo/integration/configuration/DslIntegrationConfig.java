//package com.example.springdemo.demo.integration.configuration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.IntegrationFlows;
//import org.springframework.integration.dsl.MessageChannels;
//import org.springframework.integration.file.dsl.Files;
//import org.springframework.integration.file.support.FileExistsMode;
//import java.io.File;
//
//
//@Configuration
//public class DslIntegrationConfig {
//
//    @Bean
//    public IntegrationFlow fileWriterFlow(){
//        return IntegrationFlows.from(MessageChannels.direct("textInChannel"))
//                .<String,String>transform(String::toUpperCase)
//                .channel(MessageChannels.direct("textWriterChannels"))
//                .handle(Files.outboundAdapter(new File("/Users/protocolblack/Downloads/untitled folder"))
//                .autoCreateDirectory(true)
//                        .fileExistsMode(FileExistsMode.REPLACE))
//
//                .get();
//    }
//
//
//}
