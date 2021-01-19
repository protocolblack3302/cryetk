package com.example.springdemo.demo.api.assembler;
import com.example.springdemo.demo.api.resources.TacoResource;
import com.example.springdemo.demo.api.controller.RecentOrders;
import com.example.springdemo.demo.domains.Taco;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {
    public TacoResourceAssembler(){
        super(RecentOrders.class,TacoResource.class);
    }

    @Override
    public TacoResource toModel(Taco entity) {
      return   createModelWithId(entity.getTaco_name(),entity);
    }



}
