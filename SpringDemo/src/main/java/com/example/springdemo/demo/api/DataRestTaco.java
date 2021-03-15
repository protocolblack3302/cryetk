//package com.example.springdemo.demo.api;
//
//
//import com.example.springdemo.demo.domains.Taco;
//import com.example.springdemo.demo.repositories.TacoRepository;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.client.RestTemplate;
//import java.util.List;
//
//@RequestMapping("/")
//
//public class DataRestTaco {
//
//private  RestTemplate restTemplate;
//private TacoRepository tacoRepository;
//
//
//public DataRestTaco(@LoadBalanced RestTemplate restTemplate,TacoRepository tacoRepository){
//    this.restTemplate=restTemplate;
//    this.tacoRepository=tacoRepository;
//}
//
//@GetMapping("/recent5/{name}")
//public Taco getServiceTacos(@PathVariable String name){
//    PageRequest pageRequest=PageRequest.of(0,20 ); //fetch 20 tacos list
//    List<Taco> taco_list=tacoRepository.findAll(pageRequest);
//
//   return restTemplate.getForObject("http:://data-service/recent5/{name}",Taco.class,name);
//}
//
//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//
//}
