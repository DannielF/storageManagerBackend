package com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.buys.adapter;

import com.sofka.tz.backend.storagemanager.domain.model.buy.entities.Buy;
import com.sofka.tz.backend.storagemanager.domain.model.buy.gateway.BuyRepository;
import com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.buys.ConverterBuy;
import com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.buys.data.BuyData;
import com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.buys.data.BuyDataRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Buys Adapter
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class BuyRepositoryAdapter implements BuyRepository {
    private final BuyDataRepository repository;
    private final ConverterBuy converterBuy;
    private final ReactiveMongoTemplate mongoTemplate;

    public BuyRepositoryAdapter(BuyDataRepository repository, ConverterBuy converterBuy, ReactiveMongoTemplate mongoTemplate) {
        this.repository = repository;
        this.converterBuy = converterBuy;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Flux<Buy> findAllBuys() {
        return repository.findAll().map(converterBuy::toEntityBuy);
    }

    @Override
    public Flux<Buy> findAllPaginate(Integer skip, Integer limit) {
        Query query = new Query();
        query.skip(skip);
        query.limit(limit);
        return mongoTemplate.find(query, BuyData.class)
                .map(converterBuy::toEntityBuy);
    }

    @Override
    public Mono<Buy> saveBuy(Buy buy) {
        return Mono.just(buy).map(converterBuy::toBuyData)
                .flatMap(repository::save)
                .map(converterBuy::toEntityBuy);
    }
}
