package com.bootcamp.ehs.repo;

import com.bootcamp.ehs.models.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {

    Mono<Customer> findByDocNumber (String docNumber);
}
