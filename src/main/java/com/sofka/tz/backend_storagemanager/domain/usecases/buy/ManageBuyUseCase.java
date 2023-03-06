package com.sofka.tz.backend_storagemanager.domain.usecases.buy;

import com.sofka.tz.backend_storagemanager.domain.model.buy.entities.Buy;
import com.sofka.tz.backend_storagemanager.domain.model.buy.gateway.BuyRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Buys UseCase
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@RequiredArgsConstructor
public class ManageBuyUseCase {

    private final BuyRepository repository;

    public Flux<Buy> findAllBuys() {
        return repository.findAllBuys();
    }

    public Flux<Buy> findAllPaginate(Integer skip, Integer limit) {
        return repository.findAllBy(skip, limit);
    }

    public Mono<Buy> saveBuy(Buy buy){
        return repository.saveBuy(buy);
    }
}
