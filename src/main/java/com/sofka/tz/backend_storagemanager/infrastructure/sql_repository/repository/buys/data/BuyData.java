package com.sofka.tz.backend_storagemanager.infrastructure.sql_repository.repository.buys.data;

import com.sofka.tz.backend_storagemanager.domain.product.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
/**
 * Buy DTO *  type Flat
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BuyData implements Serializable {
    private Long id;
    private String idType;
    private String idNumber;
    private String clientName;
    private List<Product> products;
}
