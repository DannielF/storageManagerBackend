package com.sofka.tz.backend_storagemanager.infrastructure.nosql_repository.repository.products.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductDataRepository extends ReactiveCrudRepository<ProductData, String> {
}
