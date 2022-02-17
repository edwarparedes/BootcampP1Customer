package com.nttdata.customer.service;

import com.nttdata.customer.entity.Customer;
import com.nttdata.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    ICustomerRepository repository;

    @Override
    public Flux<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Customer> getCustomerById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Customer> save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public Mono<Customer> update(Customer customer) {
        return repository.save(customer);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id).subscribe();
    }
}
