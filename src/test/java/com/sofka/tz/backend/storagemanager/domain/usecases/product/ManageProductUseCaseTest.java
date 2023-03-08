package com.sofka.tz.backend.storagemanager.domain.usecases.product;

import com.sofka.tz.backend.storagemanager.domain.model.product.entities.Product;
import com.sofka.tz.backend.storagemanager.domain.model.product.gateway.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ManageProductUseCaseTest {

    @InjectMocks
    private ManageProductUseCase productUseCase;

    @Mock
    private ProductRepository repository;
    @Test
    void findAll() {
        var expectedProduct = new Product();

        when(repository.findAllProducts()).thenReturn(Flux.just(expectedProduct));

        var result = productUseCase.findAll();

        StepVerifier.create(result)
                .expectNext(expectedProduct)
                .expectComplete()
                .verify();

        verify(repository).findAllProducts();
    }

    @Test
    void findAllPaginate() {
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

        when(repository.getById(expectedProduct.getId())).thenReturn(Mono.just(expectedProduct));

        var result = productUseCase.findById(expectedProduct.getId());

        StepVerifier.create(result)
                .expectNext(expectedProduct)
                .expectComplete()
                .verify();

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

        when(repository.saveProduct(toSaveProduct)).thenReturn(Mono.just(expectedProduct));

        var result = productUseCase.saveProduct(toSaveProduct);

        StepVerifier.create(result)
                .expectNext(expectedProduct)
                .expectComplete()
                .verify();

    }

    @Test
    void updateProduct() {
        var toUpdateProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(2)
                .min(1)
                .build();
        var expectedProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(2)
                .min(1)
                .build();

        when(repository.updateProduct(toUpdateProduct)).thenReturn(Mono.just(expectedProduct));

        var result = productUseCase.updateProduct(toUpdateProduct);

        StepVerifier.create(result)
                .expectNext(expectedProduct)
                .expectComplete()
                .verify();
    }

    @Test
    void decreaseInInventory() {
        var toUpdateProduct = Product.builder()
                .id("1")
                .inInventory(2)
                .enabled(true)
                .max(2)
                .min(1)
                .build();
        var expectedProduct = Product.builder()
                .id("1")
                .inInventory(1)
                .enabled(true)
                .max(2)
                .min(1)
                .build();

        when(repository.decreaseInInventory(1, toUpdateProduct.getId())).thenReturn(Mono.just(expectedProduct));

        var result = productUseCase.decreaseInInventory(1, toUpdateProduct.getId());

        StepVerifier.create(result)
                .expectNext(expectedProduct)
                .expectComplete()
                .verify();
    }

    @Test
    void deleteById() {
        var toDeleteProduct = Product.builder()
                .id("1")
                .inInventory(2)
                .enabled(true)
                .max(2)
                .min(1)
                .build();

        when(repository.deleteById(toDeleteProduct.getId())).thenReturn(Mono.empty());

        var result = productUseCase.deleteById(toDeleteProduct.getId());

        StepVerifier.create(result)
                .expectNext()
                .expectComplete()
                .verify();
    }
}