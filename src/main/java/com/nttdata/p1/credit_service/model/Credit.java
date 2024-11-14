package com.nttdata.p1.credit_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "credits")
public class Credit {
    @Id
    private String id;
    private String customerId;
    private Double amount;
    private Double balance;
    private String type; // "PERSONAL" o "BUSINESS"
    private LocalDateTime createdAt;
    private LocalDateTime dueDate;
}
