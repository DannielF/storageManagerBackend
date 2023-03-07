package com.sofka.tz.backend.storagemanager.domain.model.buy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Buys product sold
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductSold implements Serializable {
    private String id;
    private String name;
    private Integer quantity;
}
