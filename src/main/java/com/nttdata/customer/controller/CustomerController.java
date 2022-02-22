package com.nttdata.customer.controller;

import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    ICustomerService service;

    @GetMapping
    public Flux<Customer> getCustomers(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Customer>> getCustomerById(@PathVariable("id") String id){
        return service.getCustomerById(id)
                .map(savedMessage -> ResponseEntity.ok(savedMessage))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    Mono<Customer> postCustomer(@RequestBody Customer customer){
        return service.save(customer);
    }

    @PutMapping
    Mono<Customer> updCustomer(@RequestBody Customer customer){
        return service.update(customer);
    }

    @DeleteMapping("/{id}")
    void dltCustomer(@PathVariable("id") String id){
        service.delete(id);
    }

}
