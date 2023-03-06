package com.sofka.tz.backend_storagemanager.infrastructure.nosql_repository.repository.buys;

import com.sofka.tz.backend_storagemanager.domain.buy.entities.Buy;
import com.sofka.tz.backend_storagemanager.infrastructure.nosql_repository.repository.buys.data.BuyData;
import org.springframework.stereotype.Component;
/**
 * Buy Converter
 *
 * @author Daniel Granados
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class ConverterBuy {

    public Buy toEntityBuy(BuyData buyData) {
        Buy buy = new Buy();
        buy.setId(buyData.getId());
        buy.setIdType(buyData.getIdType());
        buy.setIdNumber(buyData.getIdNumber());
        buy.setClientName(buyData.getClientName());
        buy.setProducts(buyData.getProducts());
        return buy;
    }

    public BuyData toBuyData(Buy buy) {
        BuyData buyData = new BuyData();
        buyData.setId(buy.getId());
        buyData.setIdType(buy.getIdType());
        buyData.setIdNumber(buy.getIdNumber());
        buyData.setClientName(buy.getClientName());
        buyData.setProducts(buy.getProducts());
        return buyData;
    }
}
