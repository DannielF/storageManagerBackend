package com.sofka.tz.backend.storagemanager.domain.usecases.buy;

import com.sofka.tz.backend.storagemanager.domain.model.buy.gateway.BuyRepository;
import com.sofka.tz.backend.storagemanager.domain.model.exceptions.BusinessException;
import com.sofka.tz.backend.storagemanager.domain.usecases.product.ManageProductUseCase;
import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.Buy;
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
    private final ManageProductUseCase productUseCase;

    public Flux<Buy> findAllBuys() {
        return repository.findAllBuys();
    }

    public Flux<Buy> findAllPaginate(Integer skip, Integer limit) {
        return repository.findAllPaginate(skip, limit);
    }

    public Mono<Buy> saveBuy(Buy buy){
        return Flux.fromIterable(buy.getProducts())
                .flatMap(productSold -> productUseCase.findById(productSold.getId())
                .map(product -> {
                    if (product.getEnabled() == Boolean.FALSE) {
                        throw new BusinessException("Product unavailable");
                    }
                    if (product.getInInventory() == 0) {
                        throw new BusinessException("Product out of stock");
                    }
                    return product;
                }).flatMap(product -> {
                    var newQuantity = product.getInInventory() - productSold.getQuantity();
                    return productUseCase.decreaseInInventory(newQuantity, product.getId());
                }).flatMap(product -> repository.saveBuy(buy)))
                .next();
    }

    public Mono<Void> deleteById(String id) {
        return repository.deleteBuy(id);
    }
}
