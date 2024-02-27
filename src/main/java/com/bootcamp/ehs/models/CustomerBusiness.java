package com.bootcamp.ehs.models;

import com.bootcamp.ehs.dto.CustomerDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBusiness extends Customer {

    private String businessName;
    private String representative;

    public CustomerBusiness(CustomerDTO customerDTO) {
        super(customerDTO);
        this.businessName = customerDTO.getBusinessName();
        this.representative = customerDTO.getRepresentative();
    }
    @Override
    public Customer update(Customer customer) {
            CustomerBusiness updatedCustomer = (CustomerBusiness) customer;
            this.setDocNumber(updatedCustomer.getDocNumber());
            this.setAddress(updatedCustomer.getAddress());
            this.setTypeCustomer(updatedCustomer.getTypeCustomer());
            this.setStatus(updatedCustomer.getStatus());
            this.businessName = updatedCustomer.businessName;
            this.representative = updatedCustomer.representative;

        return this;
    }

    @Override
    public Customer create(CustomerDTO customerDTO) {
        return new CustomerBusiness(customerDTO);
    }

    @Override
    public Customer findById(String id) {
        return null;
    }

    @Override
    public Customer findByDocNumber(String docNumber) {
        return null;
    }
}
