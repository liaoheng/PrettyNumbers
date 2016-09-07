package org.laukvik.pretty;

import java.math.BigDecimal;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author liaoheng
 * @version 2016-07-22 16:24
 */
public class PrettyFormatTest {
    @Test public void format() throws Exception {
        String format = PrettyFormat.with().setFractionDigits(2).setUnit(ByteUnit.Kb)
                .formatRemoveLastZero("1234");
        assertEquals("1.2 Kb", format);
    }

    @Test public void autoFormat() throws Exception {
        String format = PrettyFormat.with().setFractionDigits(2)
                .setUnit(ByteUnit.getPreferredUnit(new BigDecimal("1234567"))).format("1234567");
        assertEquals("1.17 Mb", format);
    }

    @Test public void smallFormat() throws Exception {
        String format = PrettyFormat.with().setUnit(ByteUnit.Kb).setFractionDigits(2).format("200");
        assertEquals("0.19 Kb", format);
    }

    @Test public void decimalFormat() throws Exception {
        String format = PrettyFormat.with()
                .setUnit(new DecimalUnit(DecimalUnit.DecimalOptions.THOUSAND, "km"))
                .setFractionDigits(2).formatRemoveLastZero("200");
        assertEquals("0.2 km", format);
    }

    @Test
    public void removeLastZeroTest(){
        String s = Utils.removeLastZero("2.00");
        assertEquals("2", s);
    }
}