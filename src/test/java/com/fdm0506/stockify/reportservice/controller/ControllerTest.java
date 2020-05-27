package com.fdm0506.stockify.reportservice.controller;

import com.fdm0506.stockify.reportservice.share.Shares;
import com.fdm0506.stockify.reportservice.stock.Stock;
import com.fdm0506.stockify.reportservice.stock.StocksReport;
import org.bson.types.Decimal128;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void itWillReturnValidXMLResponseFromRESTEndpoint() {
        StocksReport stock = testRestTemplate.getForEntity("/api/v2/reports/stocks", StocksReport.class)
                .getBody();

        assert stock != null;
        assertEquals(stock.getStock().get(0).getSymbol(),"BOA");
        assertEquals(stock.getStock().get(2).getSymbol(),"CAP");

    }

    @Test
    public void itWillDeserialiseXMLResponseForChosenStocks() {
        String[] request = {"C", "PZZA", "HSBC"};

        StocksReport stocksReport = testRestTemplate.postForEntity(
                "/api/v2/reports/select", request, StocksReport.class)
                .getBody();

        assert stocksReport != null;
        assertEquals(stocksReport.getStock().get(0).getName(), "Citigroup");
        assertEquals(stocksReport.getStock().get(1).getName(), "Papa Johns");
        assertEquals(stocksReport.getStock().get(2).getName(), "HSBC");

    }

    @Test
    public void itWillDeserialiseXMLReponseForUserShares() {

        Shares shares = testRestTemplate.getForEntity("/api/v2/reports/shares/sudoAdmin", Shares.class)
                .getBody();

        assert shares != null;
        assertEquals(2, shares.getShares().get("HSBC"));
    }

    @Test
    public void itWillGetSymbolList() {
        List<?> symbols = testRestTemplate.getForEntity("/api/v2/reports/symbols", List.class)
                .getBody();

        assert symbols != null;
        assertEquals(symbols.get(0), "C");
        assertEquals(symbols.get(50), "CAKE");
    }


}