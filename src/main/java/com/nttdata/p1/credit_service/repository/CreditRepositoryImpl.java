package com.nttdata.p1.credit_service.repository;

import com.nttdata.p1.credit_service.model.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Repository
public class CreditRepositoryImpl implements CreditRepository {

    @Autowired
    private CreditCRUDRepository creditCRUDRepository;

    @Override
    public Mono<Credit> createCredit(Credit credit) {
        return creditCRUDRepository.findByCustomerIdAndType(credit.getCustomerId(), "PERSONAL")
                .flatMap(existingCredit -> {
                    if (existingCredit != null && credit.getType().equals("PERSONAL")) {
                        return Mono.error(new RuntimeException("El cliente ya tiene un crédito personal"));
                    }
                    credit.setCreatedAt(LocalDateTime.now());
                    return creditCRUDRepository.save(credit);
                })
                .switchIfEmpty(Mono.defer(() -> {
                    credit.setCreatedAt(LocalDateTime.now());
                    return creditCRUDRepository.save(credit);
                }));
    }

    @Override
    public Flux<Credit> getAllCredits() {
        return creditCRUDRepository.findAll();
    }

    @Override
    public Mono<Credit> findByCreditId(String id) {
        return creditCRUDRepository.findById(id);
    }

    @Override
    public Mono<Credit> updateCredit(String id, Credit credit) {
        return creditCRUDRepository.findById(id)
                .flatMap(existing->{
                    existing.setAmount(credit.getAmount());
                    existing.setBalance(credit.getBalance());
                    return creditCRUDRepository.save(existing);
                });
    }

    @Override
    public Mono<Void> deleteCredit(String id) {
        return creditCRUDRepository.deleteById(id);
    }
}
