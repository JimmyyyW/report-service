package com.fdm0506.stockify.reportservice.share;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name = "Share")
@AllArgsConstructor
@NoArgsConstructor
public class Share {
    String symbol;
    Number volume;
}
