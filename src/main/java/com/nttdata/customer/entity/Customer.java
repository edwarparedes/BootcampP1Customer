package com.nttdata.customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Customer {
    @Id
    private String id;
    private String name;
    private String type;
    private String documentType;
    private String documentNumber;
}
