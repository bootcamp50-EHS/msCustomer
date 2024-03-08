package com.bootcamp.ehs.controller;

import com.bootcamp.ehs.dto.CustomerDTO;
import com.bootcamp.ehs.models.Customer;
import com.bootcamp.ehs.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Mono<Customer> crearCustomer(@RequestBody CustomerDTO customerDTO) {
        return customerService.createCustomer(customerDTO);
    }

    @GetMapping("/{id}")
    public Mono<Customer> obtenerCustomer(@PathVariable String id) {
        return customerService.findCustomer(id);
    }

    @PutMapping("/{id}")
    public Mono<Customer> actualizarCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        return customerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCustomer(@PathVariable String id) {
        return customerService.deleteCustomer(id);
    }

    @GetMapping
    public Flux<Customer> listarCustomers() {
        return customerService.findAllCustomers();
    }
    
    @GetMapping("/bydocnumber/{docNumber}")
    public Mono<Customer> getCustomerByDocNumber(@PathVariable("docNumber") String docNumber){
        return customerService.getCustomerByDocNumber(docNumber);
    }
}
