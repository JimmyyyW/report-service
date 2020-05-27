package com.fdm0506.stockify.reportservice.stock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlElement;

@Document(collection = "stocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
//    private ObjectId _id;
    @XmlElement Number gains;
//    private boolean isPositive;
    @XmlElement String symbol;
    @XmlElement String name;
    @XmlElement Double value;
    @XmlElement Number volume;
//    private Number open;
//    private Number close;
//    private String latestTrade;
}
