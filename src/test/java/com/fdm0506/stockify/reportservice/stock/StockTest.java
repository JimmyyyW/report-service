package com.fdm0506.stockify.reportservice.stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    public void initialise() {
        Stock stock = new Stock();
        stock.setValue(2.12);
        stock.setSymbol("A");
        stock.setVolume(2134241);
        stock.setName("Age");
        stock.setGains(43);

        assertEquals("Age", stock.name);
        assertEquals(43, stock.gains);
    }

}