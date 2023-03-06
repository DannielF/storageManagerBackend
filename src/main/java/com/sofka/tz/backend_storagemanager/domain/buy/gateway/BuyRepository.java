package com.sofka.tz.backend_storagemanager.domain.buy.gateway;

import com.sofka.tz.backend_storagemanager.domain.buy.entities.Buy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BuyRepository {
    Flux<Buy> findAllBuys();
    Flux<Buy> findAllBy(Integer skip, Integer limit);
    Mono<Buy> saveBuy(Buy buy);
}
