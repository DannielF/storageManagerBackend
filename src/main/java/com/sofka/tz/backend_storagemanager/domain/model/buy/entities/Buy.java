package com.sofka.tz.backend_storagemanager.domain.model.buy.entities;

import com.sofka.tz.backend_storagemanager.domain.model.product.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Buys document
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Buy implements Serializable {

    private String id;
    private String idType;
    private String idNumber;
    private String clientName;
    private List<Product> products;
}
