package com.nttdata.p1.credit_service.repository;

import com.nttdata.p1.credit_service.model.CreditPayment;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditPaymentCRUDRepository extends ReactiveMongoRepository<CreditPayment, String> {
}
