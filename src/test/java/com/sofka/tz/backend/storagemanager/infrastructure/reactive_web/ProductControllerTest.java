package com.sofka.tz.backend.storagemanager.infrastructure.reactive_web;

import com.sofka.tz.backend.storagemanager.domain.model.product.entities.Product;
import com.sofka.tz.backend.storagemanager.domain.usecases.product.ManageProductUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    ProductController productController;

    @Mock
    ManageProductUseCase productUseCase;

    @Test
    void findAll() {
        var expectedProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(1)
                .min(1)
                .build();
        Flux<Product> productFlux = Flux.just(expectedProduct);
        when(productUseCase.findAll()).thenReturn(productFlux);

        var products = productController.findAll();
        assertThat(products).isEqualTo(productFlux);
    }

    @Test
    void findAllPaginate() {
        var expectedProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(1)
                .min(1)
                .build();
        Flux<Product> productFlux = Flux.just(expectedProduct);
        when(productUseCase.findAllPaginate(0,1)).thenReturn(productFlux);

        var products = productController.findAllPaginate(0,1);
        assertThat(products).isEqualTo(productFlux);
    }

    @Test
    void findById() {
        var expectedProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(1)
                .min(1)
                .build();
        Mono<Product> productMono = Mono.just(expectedProduct);
        when(productUseCase.findById(expectedProduct.getId())).thenReturn(productMono);

        var product = productController.findById(expectedProduct.getId());
        assertThat(product).isEqualTo(productMono);
    }

    @Test
    void saveProduct() {
        var toSaveProduct = Product.builder()
                .inInventory(1)
                .enabled(true)
                .max(1)
                .min(1)
                .build();
        var expectedProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(1)
                .min(1)
                .build();
        Mono<Product> productMono = Mono.just(expectedProduct);
        when(productUseCase.saveProduct(toSaveProduct)).thenReturn(productMono);

        var product = productController.saveProduct(toSaveProduct);
        assertThat(product).isEqualTo(productMono);
    }

    @Test
    void updateProduct() {
        var toUpdateProduct = Product.builder()
                .id("1")
                .inInventory(2)
                .enabled(true)
                .max(1)
                .min(3)
                .build();
        var expectedProduct = Product.builder()
                .id("1")
                .inInventory(2)
                .enabled(true)
                .max(1)
                .min(3)
                .build();
        Mono<Product> productMono = Mono.just(expectedProduct);
        when(productUseCase.updateProduct(toUpdateProduct)).thenReturn(productMono);

        var product = productController.updateProduct(toUpdateProduct);
        assertThat(product).isEqualTo(productMono);
    }

    @Test
    void deleteById() {
        var toDeleteProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(1)
                .min(1)
                .build();
        when(productUseCase.deleteById(toDeleteProduct.getId())).thenReturn(Mono.empty());

        var product = productController.deleteById(toDeleteProduct.getId());
        assertThat(product).isEqualTo(Mono.empty());
    }
}