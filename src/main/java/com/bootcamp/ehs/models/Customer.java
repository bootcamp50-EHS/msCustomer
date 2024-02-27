package com.bootcamp.ehs.models;

import com.bootcamp.ehs.dto.CustomerDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "customers")
public abstract class Customer {

    @Id
    private String id;
    private String docType;
    private String docNumber;
    private String address;
    private String phone;
    private String typeCustomer;
    private Boolean status;

    public Customer(CustomerDTO customerDTO){
        this.id = customerDTO.getId();
        this.docType = customerDTO.getDocType();
        this.docNumber = customerDTO.getDocNumber();
        this.address = customerDTO.getAddress();
        this.phone = customerDTO.getPhone();
        this.typeCustomer = customerDTO.getTypeCustomer();
        this.status = customerDTO.getStatus();
    }

    public abstract Customer update(Customer client);
    public abstract Customer create(CustomerDTO clientDTO);
    public abstract Customer findById(String id);
    public abstract Customer findByDocNumber(String docNumber);
}
