package com.sofka.tz.backend.storagemanager.infrastructure.reactive_web;

import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.Buy;
import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.ProductSold;
import com.sofka.tz.backend.storagemanager.domain.usecases.buy.ManageBuyUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuyControllerTest {

    @InjectMocks
    BuyController buyController;

    @Mock
    ManageBuyUseCase buyUseCase;
    @Test
    void findAll() {
        var productSold = ProductSold.builder()
                .id("1")
                .name("1")
                .quantity(1)
                .build();
        var listProductSold = List.of(productSold);
        var expectedBuy =  Buy.builder()
                .id("1")
                .clientName("1")
                .idNumber("1")
                .idType("CC")
                .products(listProductSold)
                .build();
        Flux<Buy> buyFlux = Flux.just(expectedBuy);
        when(buyUseCase.findAllBuys()).thenReturn(buyFlux);

        var buys = buyController.findAll();
        assertThat(buys).isEqualTo(buyFlux);
    }

    @Test
    void findAllPaginate() {
        var productSold = ProductSold.builder()
                .id("1")
                .name("1")
                .quantity(1)
                .build();
        var listProductSold = List.of(productSold);
        var expectedBuy =  Buy.builder()
                .id("1")
                .clientName("1")
                .idNumber("1")
                .idType("CC")
                .products(listProductSold)
                .build();
        Flux<Buy> buyFlux = Flux.just(expectedBuy);
        when(buyUseCase.findAllPaginate(0,1)).thenReturn(buyFlux);

        var buys = buyController.findAllPaginate(0,1);
        assertThat(buys).isEqualTo(buyFlux);
    }

    @Test
    void saveBuy() {
        var productSold = ProductSold.builder()
                .id("1")
                .name("1")
                .quantity(1)
                .build();
        var listProductSold = List.of(productSold);
        var toSaveBuy =  Buy.builder()
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
        Mono<Buy> buyMono = Mono.just(expectedBuy);
        when(buyUseCase.saveBuy(toSaveBuy)).thenReturn(buyMono);

        var buy = buyController.saveBuy(toSaveBuy);
        assertThat(buy).isEqualTo(buyMono);
    }

    @Test
    void deleteById() {
        var productSold = ProductSold.builder()
                .id("1")
                .name("1")
                .quantity(1)
                .build();
        var listProductSold = List.of(productSold);
        var toDeleteBuy =  Buy.builder()
                .id("1")
                .clientName("1")
                .idNumber("1")
                .idType("CC")
                .products(listProductSold)
                .build();
        when(buyUseCase.deleteById(toDeleteBuy.getId())).thenReturn(Mono.empty());

        var buy = buyController.deleteById(toDeleteBuy.getId());
        assertThat(buy).isEqualTo(Mono.empty());
    }
}