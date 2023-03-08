package com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.products.adapter;

import com.sofka.tz.backend.storagemanager.domain.model.exceptions.BusinessException;
import com.sofka.tz.backend.storagemanager.domain.model.product.gateway.ProductRepository;
import com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.products.ConverterProduct;
import com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.products.data.ProductData;
import com.sofka.tz.backend.storagemanager.domain.model.product.entities.Product;
import com.sofka.tz.backend.storagemanager.infrastructure.nosql_repository.repository.products.data.ProductDataRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Product adapter
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public class ProductRepositoryAdapter implements ProductRepository {

    private final ProductDataRepository repository;
    private final ConverterProduct converterProduct;
    private final ReactiveMongoTemplate mongoTemplate;

    public ProductRepositoryAdapter(ProductDataRepository repository, ConverterProduct converterProduct, ReactiveMongoTemplate mongoTemplate) {
        this.repository = repository;
        this.converterProduct = converterProduct;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Flux<Product> findAllProducts() {
        return repository.findAll().map(converterProduct::toEntityProduct);
    }

    @Override
    public Flux<Product> findAllPaginated(Integer skip, Integer limit) {
        Query query = new Query();
        query.skip(skip);
        query.limit(limit);
        return mongoTemplate.find(query, ProductData.class)
                .map(converterProduct::toEntityProduct);
    }

    @Override
    public Mono<Product> getById(String id) {
        return repository.findById(id)
                .map(converterProduct::toEntityProduct)
                .switchIfEmpty(Mono.error(new BusinessException("Product not found")));
    }

    @Override
    public Mono<Product> saveProduct(Product product) {
        return Mono.just(product).map(converterProduct::toProductData)
                .flatMap(repository::save)
                .map(converterProduct::toEntityProduct);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        var criteria = Criteria.where("_id").is(new ObjectId(product.getId()));
        Update update = new Update().set("name", product.getName()).
                set("min", product.getMin()).
                set("max", product.getMax()).
                set("enabled", product.getEnabled()).
                set("inInventory", product.getInInventory());
        return mongoTemplate.findAndModify(new Query(criteria), update, ProductData.class)
                .map(converterProduct::toEntityProduct);
    }

    @Override
    public Mono<Product> decreaseInInventory(Integer value, String id) {
        var criteria = Criteria.where("_id").is(new ObjectId(id));
        Update update = new Update().set("inInventory", value);
        return mongoTemplate.findAndModify(new Query(criteria), update, ProductData.class)
                .map(converterProduct::toEntityProduct);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return repository.deleteById(id);
    }
}
