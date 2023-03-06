package com.sofka.tz.backend_storagemanager.domain.buy.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sofka.tz.backend_storagemanager.domain.product.entities.Product;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Buys entity
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
@AllArgsConstructor
@Entity
@Table(name = "buys")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buy_id")
    private Long id;
    @Column(name = "buy_idType", nullable = false, length = 3)
    private String idType;
    @Column(name = "buy_idNumber", nullable = false, length = 10)
    private String idNumber;
    @Column(name = "buy_cltName", nullable = false, length = 50)
    private String clientName;
    @OneToMany(mappedBy = "buys",
            targetEntity = Product.class,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> products;
}
