package com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.products.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Product repository
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
public interface ProductDataRepository extends ReactiveCrudRepository<ProductData, String> {
}
