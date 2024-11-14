package com.nttdata.p1.credit_service.service;

import com.nttdata.p1.credit_service.model.CreditPayment;
import com.nttdata.p1.credit_service.repository.CreditPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditPaymentServiceImpl implements CreditPaymentService {

    @Autowired
    private CreditPaymentRepository creditPaymentRepository;

    @Override
    public Mono<CreditPayment> createCreditPayment(CreditPayment creditPayment) {
        return creditPaymentRepository.createCreditPayment(creditPayment);
    }

    @Override
    public Flux<CreditPayment> getAllCreditPayments() {
        return creditPaymentRepository.getAllCreditPayments();
    }

    @Override
    public Mono<CreditPayment> findByCreditPaymentId(String id) {
        return creditPaymentRepository.findByCreditPaymentId(id);
    }

    @Override
    public Mono<CreditPayment> updateCreditPayment(String id, CreditPayment creditPayment) {
        return creditPaymentRepository.updateCreditPayment(id, creditPayment);
    }

    @Override
    public Mono<Void> deleteCreditPayment(String id) {
        return creditPaymentRepository.deleteCreditPayment(id);
    }
}
