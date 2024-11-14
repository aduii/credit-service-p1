package com.nttdata.p1.credit_service.repository;

import com.nttdata.p1.credit_service.model.CreditPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CreditPaymentRepositoryImpl implements CreditPaymentRepository {

    @Autowired
    private CreditPaymentCRUDRepository creditPaymentCRUDRepository;

    @Override
    public Mono<CreditPayment> createCreditPayment(CreditPayment creditPayment) {
        return creditPaymentCRUDRepository.save(creditPayment);
    }

    @Override
    public Flux<CreditPayment> getAllCreditPayments() {
        return creditPaymentCRUDRepository.findAll();
    }

    @Override
    public Mono<CreditPayment> findByCreditPaymentId(String id) {
        return creditPaymentCRUDRepository.findById(id);
    }

    @Override
    public Mono<CreditPayment> updateCreditPayment(String id, CreditPayment creditPayment) {
        return creditPaymentCRUDRepository.findById(id)
                .flatMap(existing->{
                    existing.setPaymentAmount(creditPayment.getPaymentAmount());
                    existing.setPaymentDate(creditPayment.getPaymentDate());
                    return creditPaymentCRUDRepository.save(existing);
                });
    }

    @Override
    public Mono<Void> deleteCreditPayment(String id) {
        return creditPaymentCRUDRepository.deleteById(id);
    }
}
