package com.bootcamp.ehs.service.Impl;

import com.bootcamp.ehs.dto.CustomerDTO;
import com.bootcamp.ehs.models.Customer;
import com.bootcamp.ehs.models.CustomerBusiness;
import com.bootcamp.ehs.models.CustomerPerson;
import com.bootcamp.ehs.service.CustomerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerFactoryImpl implements CustomerFactory {


    @Override
    public Customer create(CustomerDTO customerDTO) {
        log.info("en CustomerfactoryImpl :"+ customerDTO.getTypeCustomer());
        if ("Personal".equals(customerDTO.getTypeCustomer())) {
            return new CustomerPerson(customerDTO);
        } else if ("Empresarial".equals(customerDTO.getTypeCustomer())) {
            return new CustomerBusiness(customerDTO);
        } else {
            throw new IllegalArgumentException("Tipo de cliente desconocido: " + customerDTO.getTypeCustomer());
        }
    }

    @Override
    public Customer getCustomer(String customerId) {
        return null;
    }


}
