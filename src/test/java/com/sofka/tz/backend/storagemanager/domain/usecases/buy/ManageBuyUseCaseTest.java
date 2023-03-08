package com.sofka.tz.backend.storagemanager.domain.usecases.buy;

import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.Buy;
import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.ProductSold;
import com.sofka.tz.backend.storagemanager.domain.model.buy.gateway.BuyRepository;
import com.sofka.tz.backend.storagemanager.domain.usecases.product.ManageProductUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ManageBuyUseCaseTest {

    @InjectMocks
    private ManageBuyUseCase buyUseCase;

    @Mock
    private BuyRepository repository;

    @Mock
    private ManageProductUseCase productUseCase;

    @Test
    void findAllBuys() {
        var expectedBuy = new Buy();

        when(repository.findAllBuys()).thenReturn(Flux.just(expectedBuy));

        var result = buyUseCase.findAllBuys();

        StepVerifier.create(result)
                .expectNext(expectedBuy)
                .expectComplete()
                .verify();

        verify(repository).findAllBuys();
    }

    @Test
    void findAllPaginate() {
        var expectedBuy = new Buy();

        when(repository.findAllPaginate(0, 1)).thenReturn(Flux.just(expectedBuy));

        var result = buyUseCase.findAllPaginate(0, 1);

        StepVerifier.create(result)
                .expectNext(expectedBuy)
                .expectComplete()
                .verify();
    }

    @Test
    void saveBuy() {
//        var productSold = ProductSold.builder()
//                .id("1")
//                .name("1")
//                .quantity(1)
//                .build();
//        var listProductSold = List.of(productSold);
//        var expectedProduct = Product.builder()
//                .id("1")
//                .inInventory(1)
//                .enabled(true)
//                .max(1)
//                .min(1)
//                .build();
//        var buyToSave = Buy.builder()
//                .clientName("1")
//                .idNumber("1")
//                .idType("CC")
//                .products(listProductSold)
//                .build();
//        var expectedBuy =  Buy.builder()
//                .id("1")
//                .clientName("1")
//                .idNumber("1")
//                .idType("CC")
//                .products(listProductSold)
//                .build();
//
//        when(repository.saveBuy(buyToSave)).thenReturn(Mono.just(expectedBuy));
//        when(productUseCase.findById(productSold.getId())).thenReturn(Mono.just(expectedProduct));
//
//        var result = buyUseCase.saveBuy(buyToSave);
//
//        StepVerifier.create(result)
//                .expectNext(expectedBuy)
//                .expectComplete()
//                .verify();
    }

    @Test
    void deleteById() {
        var productSold = ProductSold.builder()
                .id("1")
                .name("1")
                .quantity(1)
                .build();
        var listProductSold = List.of(productSold);
        var buyToDelete = Buy.builder()
                .clientName("1")
                .idNumber("1")
                .idType("CC")
                .products(listProductSold)
                .build();

        when(repository.deleteBuy(buyToDelete.getId())).thenReturn(Mono.empty());

        var result = buyUseCase.deleteById(buyToDelete.getId());

        StepVerifier.create(result)
                .expectNext()
                .expectComplete()
                .verify();
    }
}