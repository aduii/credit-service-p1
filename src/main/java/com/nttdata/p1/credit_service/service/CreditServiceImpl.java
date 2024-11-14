package com.nttdata.p1.credit_service.service;

import com.nttdata.p1.credit_service.model.Credit;
import com.nttdata.p1.credit_service.repository.CreditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepository creditRepository;

    @Override
    public Mono<Credit> createCredit(Credit credit) {
        return creditRepository.createCredit(credit);
    }

    @Override
    public Flux<Credit> getAllCredits() {
        return creditRepository.getAllCredits();
    }

    @Override
    public Mono<Credit> findByCreditId(String id) {
        return creditRepository.findByCreditId(id);
    }

    @Override
    public Mono<Credit> updateCredit(String id, Credit credit) {
        return creditRepository.updateCredit(id, credit);
    }

    @Override
    public Mono<Void> deleteCredit(String id) {
        return creditRepository.deleteCredit(id);
    }
}
