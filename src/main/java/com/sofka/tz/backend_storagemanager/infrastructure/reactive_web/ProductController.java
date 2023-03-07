package com.sofka.tz.backend_storagemanager.infrastructure.reactive_web;

import com.sofka.tz.backend_storagemanager.domain.model.product.entities.Product;
import com.sofka.tz.backend_storagemanager.domain.usecases.product.ManageProductUseCase;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product Rest Controller
 *
 * @author daniel.granados
 * @version 0.0.1
 * @since 0.0.1
 */
@RestControllerAdvice
@AllArgsConstructor
@RequestMapping(value = "/product")
@CrossOrigin(origins = "*")
public class ProductController {

    private final ManageProductUseCase useCase;
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private Flux<Product> findAll() {
        return useCase.findAll();
    }

    @GetMapping("/paginate/{skip}:{limit}")
    @ResponseStatus(HttpStatus.OK)
    private Flux<Product> findAllPaginate(@PathVariable Integer skip,@PathVariable Integer limit) {
        return useCase.findAllPaginate(skip, limit);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    private Mono<Product> findById(@PathVariable String id) {
        return useCase.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Product> saveProduct(@RequestBody Product product) {
        logger.info("Product created {}", product.toBuilder());
        return useCase.saveProduct(product);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    private Mono<Product> updateProduct(@RequestBody Product product) {
        logger.info("Product updated {}", product.toBuilder());
        return useCase.updateProduct(product);
    }
}
