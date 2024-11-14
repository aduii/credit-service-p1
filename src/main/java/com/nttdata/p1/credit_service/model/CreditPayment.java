package com.nttdata.p1.credit_service.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "credit_payments")
public class CreditPayment {
    @Id
    private String id;
    private String creditId;
    private Double paymentAmount;
    private LocalDateTime paymentDate;
}
