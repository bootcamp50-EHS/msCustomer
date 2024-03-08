package com.bootcamp.ehs.service;

import com.bootcamp.ehs.dto.CustomerDTO;
import com.bootcamp.ehs.models.Customer;
import com.bootcamp.ehs.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CustomerService {

    private final CustomerFactory customerFactory;
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerFactory customerFactory, CustomerRepository customerRepository) {
        this.customerFactory = customerFactory;
        this.customerRepository = customerRepository;
    }

    public Mono<Customer> createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerFactory.create(customerDTO);
        log.info("En Service",customer);
        return customerRepository.save(customer);
    }

    public Mono<Customer> findCustomer(String id) {
        return customerRepository.findById(id);
    }

    public Mono<Customer> updateCustomer(String id, CustomerDTO customerDTO) {
        log.info("Entrando a update "+customerDTO.getTypeCustomer());

        return customerRepository.findById(id)
                .map(customerExisting -> {
                    Customer customerUpdated = customerFactory.create(customerDTO);
                    customerExisting.update(customerUpdated);

                    return customerExisting;
                })
                .flatMap(customerRepository::save);
    }

    public Mono<Void> deleteCustomer(String id) {
        return customerRepository.deleteById(id);
    }

    public Flux<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Mono<Customer> getCustomerByDocNumber(String docNumber){
        return customerRepository.findByDocNumber(docNumber);
    }

}
