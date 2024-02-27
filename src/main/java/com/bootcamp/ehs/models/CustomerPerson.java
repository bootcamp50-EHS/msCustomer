package com.bootcamp.ehs.models;

import com.bootcamp.ehs.dto.CustomerDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerPerson extends Customer {

    private String firstName;
    private String lastName;
    private String civilStatus;

    public CustomerPerson(CustomerDTO customerDTO) {
        super(customerDTO);
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.civilStatus = customerDTO.getCivilStatus();
    }

    @Override
    public Customer update(Customer customer) {
        CustomerPerson updatedCustomer = (CustomerPerson) customer;
        this.setDocType(updatedCustomer.getDocType());
        this.setDocNumber(updatedCustomer.getDocNumber());
        this.setAddress(updatedCustomer.getAddress());
        this.setPhone(updatedCustomer.getPhone());
        this.setTypeCustomer(updatedCustomer.getTypeCustomer());
        this.setStatus(updatedCustomer.getStatus());

        this.firstName = updatedCustomer.getFirstName();
        this.lastName = updatedCustomer.getLastName();
        this.civilStatus = updatedCustomer.getCivilStatus();
        return this;
    }

    @Override
    public Customer create(CustomerDTO customerDTO) {
        CustomerPerson customerPerson = new CustomerPerson(customerDTO);
        customerPerson.setId(customerDTO.getId());
        customerPerson.setDocType(customerDTO.getDocType());
        customerPerson.setDocNumber(customerDTO.getDocNumber());
        customerPerson.setAddress(customerDTO.getAddress());
        customerPerson.setFirstName(customerDTO.getFirstName());
        customerPerson.setLastName(customerDTO.getLastName());
        customerPerson.setCivilStatus(customerDTO.getCivilStatus());
        return customerPerson;

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
