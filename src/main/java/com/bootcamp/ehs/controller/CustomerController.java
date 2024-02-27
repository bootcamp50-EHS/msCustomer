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

    private final CustomerService costumerService;

    public CustomerController(CustomerService costumerService) {
        this.costumerService = costumerService;
    }

    @PostMapping
    public Mono<Customer> crearCustomer(@RequestBody CustomerDTO customerDTO) {
        return costumerService.createCustomer(customerDTO);
    }

    @GetMapping("/{id}")
    public Mono<Customer> obtenerCustomer(@PathVariable String id) {
        return costumerService.findCustomer(id);
    }

    @PutMapping("/{id}")
    public Mono<Customer> actualizarCustomer(@PathVariable String id, @RequestBody CustomerDTO customerDTO) {
        return costumerService.updateCustomer(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> eliminarCustomer(@PathVariable String id) {
        return costumerService.deleteCustomer(id);
    }

    @GetMapping
    public Flux<Customer> listarCustomers() {
        return costumerService.findAllCustomers();
    }
}
