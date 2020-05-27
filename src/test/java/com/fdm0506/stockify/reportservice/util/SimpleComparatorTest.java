package com.fdm0506.stockify.reportservice.util;

import com.fdm0506.stockify.reportservice.stock.Stock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleComparatorTest {

    SimpleComparator unit = new SimpleComparator();

    @Test
    public void itCanCompare() {

        Stock stock = new Stock();
        stock.setValue(242.20);

        Stock stock2 = new Stock();
        stock2.setValue(243.21);
        int compare = unit.compare(stock, stock2);

        assertEquals(-1, compare);
    }

    @Test
    public void itCanCompareBackwards() {

        Stock stock = new Stock();
        stock.setValue(242.20);

        Stock stock2 = new Stock();
        stock2.setValue(243.21);
        int compare = unit.compare(stock2, stock);

        assertEquals(1, compare);
    }

}