package com.sofka.tz.backend_storagemanager.infrastructure.nosql_repository.repository.buys.data;

import com.sofka.tz.backend_storagemanager.domain.model.buy.entities.ProductSold;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
/**
 * Buy Data
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@Document
public class BuyData{
    @Id
    private String id;
    private String idType;
    private String idNumber;
    private String clientName;
    private List<ProductSold> products;
}
