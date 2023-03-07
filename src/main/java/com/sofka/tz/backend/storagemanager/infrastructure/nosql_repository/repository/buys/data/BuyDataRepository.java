package com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.buys.data;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * Buys repository
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
public interface BuyDataRepository extends ReactiveMongoRepository<BuyData, String> {
}
