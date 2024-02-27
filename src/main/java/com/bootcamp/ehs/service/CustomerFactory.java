package com.bootcamp.ehs.service;

import com.bootcamp.ehs.dto.CustomerDTO;
import com.bootcamp.ehs.models.Customer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface CustomerFactory {

    Customer create(CustomerDTO customerDTO);

}
