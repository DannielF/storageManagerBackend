package com.sofka.tz.backend_storagemanager.domain.model.buy.gateway;

import com.sofka.tz.backend_storagemanager.domain.model.buy.entities.Buy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Buys interface
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BuyRepository {
    Flux<Buy> findAllBuys();
    Flux<Buy> findAllPaginate(Integer skip, Integer limit);
    Mono<Buy> saveBuy(Buy buy);
}
