package com.example.springdemo.demo.api.controller;
import com.example.springdemo.demo.api.assembler.TacoResourceAssembler;
import com.example.springdemo.demo.api.resources.TacoResource;
import com.example.springdemo.demo.domains.Taco;
import com.example.springdemo.demo.repositories.TacoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/design",produces = "application/json")
@CrossOrigin(origins ="*")
@RequiredArgsConstructor
public class RecentOrders {

    private final TacoRepository tacoRepository;

    @GetMapping("/recent")
    public CollectionModel<TacoResource> recentTacos(){
        PageRequest pageRequest=PageRequest.of(0,20 ); //fetch 20 tacos list
        List<Taco> taco_list=tacoRepository.findAll(pageRequest);
        CollectionModel<TacoResource> collectionModel=new TacoResourceAssembler().toCollectionModel(taco_list); //convert list of tacos to taco resource
        collectionModel.add(linkTo(methodOn(RecentOrders.class).recentTacos()).withRel("recent"));  //add links to json
        return collectionModel;
    }


    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepository.save(taco);
    }


    @GetMapping("/{Id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("Id") String id){
        Optional<Taco> optTaco=tacoRepository.findById(id);
        return optTaco.map(taco -> new ResponseEntity<>(taco, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }


}
