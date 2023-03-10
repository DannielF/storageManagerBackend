package com.sofka.tz.backend.storagemanager.domain.model.product.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Product document
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Product implements Serializable {

    private String id;
    private String name;
    private Integer inInventory;
    private Boolean enabled;
    private Integer min;
    private Integer max;
}
