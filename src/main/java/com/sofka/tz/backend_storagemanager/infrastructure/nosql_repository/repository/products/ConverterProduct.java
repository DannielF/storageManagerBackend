package com.sofka.tz.backend_storagemanager.infrastructure.nosql_repository.repository.products;

import com.sofka.tz.backend_storagemanager.domain.model.product.entities.Product;
import com.sofka.tz.backend_storagemanager.infrastructure.nosql_repository.repository.products.data.ProductData;
import org.springframework.stereotype.Component;

/**
 * Product Converter
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ConverterProduct {

    public Product toEntityProduct (ProductData productData){
        Product product = new Product();
        product.setId(productData.getId());
        product.setName(productData.getName());
        product.setEnabled(productData.getEnabled());
        product.setMin(productData.getMin());
        product.setMax(productData.getMax());
        product.setInInventory(productData.getInInventory());
        return product;
    }

    public ProductData toProductData (Product product){
        ProductData productData = new ProductData();
        productData.setId(product.getId());
        productData.setName(product.getName());
        productData.setEnabled(product.getEnabled());
        productData.setMin(product.getMin());
        productData.setMax(product.getMax());
        productData.setInInventory(product.getInInventory());
        return productData;
    }
}
