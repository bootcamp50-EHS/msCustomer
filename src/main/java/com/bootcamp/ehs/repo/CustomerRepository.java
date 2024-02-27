package com.bootcamp.ehs.repo;

import com.bootcamp.ehs.models.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
