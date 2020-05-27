package com.fdm0506.stockify.reportservice.util;


import com.fdm0506.stockify.reportservice.stock.Stock;

import java.util.Comparator;

public class SimpleComparator implements Comparator<Stock> {

    @Override
    public int compare(Stock o1, Stock o2) {
        return o1.getValue().compareTo(o2.getValue());
    }
}