package com.sofka.tz.backend.storagemanager.domain.usecases.buy;

import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.Buy;
import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.ProductSold;
import com.sofka.tz.backend.storagemanager.domain.model.buy.gateway.BuyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManageBuyUseCaseTest {

    @InjectMocks
    private ManageBuyUseCase buyUseCase;

    @Mock
    private BuyRepository repository;

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
    }

    @Test
    void saveBuy() {
        var productSold = ProductSold.builder()
                .id("1")
                .name("1")
                .quantity(1)
                .build();
        var listProductSold = List.of(productSold);
        var buyToSave = Buy.builder()
                .clientName("1")
                .idNumber("1")
                .idType("CC")
                .products(listProductSold)
                .build();
        var expectedBuy =  Buy.builder()
                .id("1")
                .clientName("1")
                .idNumber("1")
                .idType("CC")
                .products(listProductSold)
                .build();

        when(repository.saveBuy(buyToSave)).thenReturn(Mono.just(expectedBuy));

        var result = buyUseCase.saveBuy(buyToSave);

        StepVerifier.create(result)
                .expectNext(expectedBuy)
                .expectComplete()
                .verify();
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