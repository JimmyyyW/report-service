package com.fdm0506.stockify.reportservice.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fdm0506.stockify.reportservice.stock.Stock;
import com.fdm0506.stockify.reportservice.stock.StocksReport;
import com.fdm0506.stockify.reportservice.util.SimpleComparator;
import com.google.gson.Gson;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockRepository {

    private static final String url = "http://localhost:8090/api/v2/stocks/xml";
    private Gson gson = new Gson();

    public StocksReport getStocks() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);


        Stock[] stockList = gson.fromJson(response.getBody(), Stock[].class);
        List<Stock> list = Arrays.asList(stockList);
        list.sort(new SimpleComparator());
        StocksReport stocks = new StocksReport();
        stocks.setStock(list);
        return stocks;
    }

    public List<String> getSymbols() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);
        Stock[] stockList = gson.fromJson(response.getBody(), Stock[].class);
        List<Stock> list = Arrays.asList(stockList);

        return list.stream()
                .map(Stock::getSymbol)
                .collect(Collectors.toList());
    }

}
