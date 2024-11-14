package com.nttdata.p1.credit_service.repository;

import com.nttdata.p1.credit_service.model.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CreditCRUDRepository extends ReactiveMongoRepository<Credit, String> {
    Mono<Credit> findByCustomerIdAndType(String customerId, String type);

}
