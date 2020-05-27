package com.fdm0506.stockify.reportservice.stock;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class StocksReportTest {

    @Test
    public void initialise() {
        StocksReport report = new StocksReport();
        Stock stock = new Stock();
        stock.setValue(2.12);
        stock.setSymbol("A");
        stock.setVolume(2134241);
        stock.setName("Age");
        stock.setGains(43);

        report.setStock(Collections.singletonList(stock));

        assertEquals(stock, report.getStock().get(0));
    }

}