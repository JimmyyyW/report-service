package com.fdm0506.stockify.reportservice.share;

import org.bson.types.Decimal128;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SharesTest {

    @Test
    public void initialise() {
        Shares shares = new Shares();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("hello", 213);

        shares.setShares(map);

        assertEquals(213, map.get("hello"));
    }

}