package com.sofka.tz.backend_storagemanager.domain.product.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sofka.tz.backend_storagemanager.domain.buy.entities.Buy;
import jakarta.persistence.*;
import lombok.*;

/**
 * Product entity
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pd_id")
    private Long id;
    @Column(name = "pd_name", nullable = false, length = 100)
    private String name;
    @Column(name = "pd_quantity", nullable = false)
    private Integer inInventory;
    @Column(name = "pd_enabled", nullable = false)
    private Boolean enabled;
    @Column(name = "pd_min", nullable = false)
    private Integer min;
    @Column(name = "pd_max", nullable = false)
    private Integer max;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY,
            targetEntity = Buy.class,
            optional = false)
    @JoinColumn(name = "buys_id")
    @JsonBackReference
    private Buy buys;
}
