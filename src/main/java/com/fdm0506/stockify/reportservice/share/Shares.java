package com.fdm0506.stockify.reportservice.share;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.Decimal128;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Map;

@Data
@Document(collection = "user-shares")
@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
public class Shares {
    String user;
    Map<String, Integer> shares;
}
