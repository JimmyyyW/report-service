package com.fdm0506.stockify.reportservice.share;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShareTest {

    @Test
    public void instantiate() {
        Share share = new Share();
        share.setSymbol("S");
        share.setVolume(21333);

        assertEquals("S", share.getSymbol());
        assertEquals(21333, share.getVolume());
    }

}