//package com.example.springdemo.demo.messaging;
//
//import com.example.springdemo.demo.integration.gateway.FIleWriterGateway;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@Service
//@RequestMapping("/")
//public class kafkaOrderService {
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private final FIleWriterGateway fIleWriterGateway;
//    private static final String kafkatopic="mykafkatopic1";
//
//    @GetMapping("/kafka/{message}")
//    public ResponseEntity<String> sendOrder(@PathVariable("message") final String message ){
//        kafkaTemplate.send(kafkatopic,message);
//        fIleWriterGateway.writeToFile("harshinteg.txt",message);
//      return  new ResponseEntity<>("<h1> kafka message returned </h1>" , HttpStatus.OK);
//    }
//
//
//}
