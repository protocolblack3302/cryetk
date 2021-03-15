package com.example.springdemo.demo.messaging;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class JMSOrderMessagingService {

    private final JmsTemplate jmsTemplate;


    @GetMapping(value = "send/{message}")

    public ResponseEntity<String> sendOrder(@PathVariable(name = "message") String message){  //injecting destination bean
      //  jmsTemplate.send(session -> session.createObjectMessage(message)); //default queue
        jmsTemplate.convertAndSend( message);
        //doesnt require messagecreator passed by lambda and we have mentioned here the desination queue manuallyr
        return new ResponseEntity<>("<H1>message sent ok</H1>", HttpStatus.OK);
    }
//
//    @Bean
//    Destination getMessageDestination(){
//       return new ActiveMQQueue("myqueue");  //creating a bean to define a destination queue which can be
//        //injected as destination object which is used as an address to send messages
//        //another way is to set default destination queue in application.properties and dont send any destination into
//        //the method
//    }

}
