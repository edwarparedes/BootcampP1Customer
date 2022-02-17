package com.nttdata.customer.service;

import com.nttdata.customer.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService {

    Flux<Customer> getAll();

    Mono<Customer> getCustomerById(String id);

    Mono<Customer> save(Customer customer);

    Mono<Customer> update(Customer customer);

    void delete(String id);
}
