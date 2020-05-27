package com.fdm0506.stockify.reportservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fdm0506.stockify.reportservice.repository.SharesRepository;
import com.fdm0506.stockify.reportservice.repository.StockRepository;
import com.fdm0506.stockify.reportservice.share.Shares;
import com.fdm0506.stockify.reportservice.stock.StocksReport;
import lombok.AllArgsConstructor;
import org.bson.types.Decimal128;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class Controller {

    private SharesRepository sharesRepository;
    private StockRepository stockRepository;

    @GetMapping(value = "/api/v2/reports/stocks", produces = MediaType.APPLICATION_XML_VALUE)
    public StocksReport getAllStocks()  {
        return stockRepository.getStocks();
    }

    @PostMapping(value = "/api/v2/reports/select", produces = MediaType.APPLICATION_XML_VALUE)
    public StocksReport getChosenStocks(@RequestBody String[] chosenStocks){
        System.out.println(Arrays.toString(chosenStocks));
        List<String> strings = Arrays.asList(chosenStocks);
        StocksReport stocks = stockRepository.getStocks();
        stocks.setStock(stocks.getStock()
                .stream()
                .filter(stock -> strings.contains(stock.getSymbol()))
                .collect(Collectors.toList()));
        return stocks;
    }

    @GetMapping(value = "/api/v2/reports/shares/{username}", produces = MediaType.APPLICATION_XML_VALUE)
    public Shares getAllUserShares(@PathVariable String username) {
        Shares byUsername = sharesRepository.findByUser(username);
        Map<String, Integer> treeMap = new TreeMap<>(Comparator.naturalOrder());
        treeMap.putAll(byUsername.getShares());
        byUsername.setShares(treeMap);
        return byUsername;
    }

    @GetMapping(value = "/api/v2/reports/symbols", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> symbols() {
        return stockRepository.getSymbols();
    }
}
