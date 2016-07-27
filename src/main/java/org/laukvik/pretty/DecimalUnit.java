package org.laukvik.pretty;

import java.math.BigDecimal;

/**
 * 十进制
 * @author liaoheng
 * @version 2016-07-27 14:17
 */
public class DecimalUnit implements Unit {

    public enum DecimalOptions {
        DIGITS(1), TEN(10), HUNDRED(100), THOUSAND(1000), TEN_THOUSAND(10000),
        ONE_HUNDRED_THOUSAND(100000);
        private int value;

        DecimalOptions(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private int    value;
    private String suffix;

    public DecimalUnit(int value, String suffix) {
        this.value = value;
        this.suffix = suffix;
    }

    public DecimalUnit(DecimalOptions value, String suffix) {
        this.value = value.getValue();
        this.suffix = suffix;
    }

    @Override public BigDecimal getValue() {
        return new BigDecimal(value);
    }

    @Override public int value() {
        return value;
    }

    @Override public String getName() {
        return suffix;
    }
}
