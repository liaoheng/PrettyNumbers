/*
 * Copyright 2013 Laukviks Bedrifter.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.laukvik.pretty;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Formats numbers according to a Unit's formatting rules
 *
 *
 * @author Morten Laukvik
 */
public class PrettyFormat {

    private Unit unit;
    private int fractionDigits = 2;

    private PrettyFormat() {
    }

    public static PrettyFormat with() {
        return new PrettyFormat();
    }

    public Unit getUnit() {
        return unit;
    }

    /**
     * Sets the Unit to use when formatting a number
     *
     * @param unit
     */
    public PrettyFormat setUnit(Unit unit) {
        this.unit = unit;
        return this;
    }

    public int getFractionDigits() {
        return fractionDigits;
    }

    /**
     * Sets the amount of fraction digits to use when formatting a number
     *
     * @param fractionDigits
     */
    public PrettyFormat setFractionDigits(int fractionDigits) {
        this.fractionDigits = fractionDigits;
        return this;
    }

    /**
     * Returns the new formatted number without the unit name
     *
     * @param value
     * @return
     */
    public BigDecimal getValue(BigDecimal value) {
        return value.divide(unit.getValue()).setScale(fractionDigits, RoundingMode.FLOOR);
    }

    /**
     * Returns the new formatted number without the unit name
     *
     * @param value
     * @return
     */
    public String getValueString(BigDecimal value) {
        return String.valueOf(getValue(value));
    }

    /**
     * Formats a number based on the current Unit
     *
     * @param value
     * @return
     */
    public String format(BigDecimal value) {
        return getValue(value) + " " + unit.getName();
    }

    public String format(Number value) {
        return format(String.valueOf(value));
    }

    public String format(String value) {
        checkNumber(value);
        return format(new BigDecimal(value));
    }

    public String formatRemoveLastZero(Number value) {
        return formatRemoveLastZero(String.valueOf(value));
    }

    public String formatRemoveLastZero(String value) {
        checkNumber(value);
        return formatRemoveLastZero(new BigDecimal(value));
    }

    public String formatRemoveLastZero(BigDecimal value) {
        return Utils.removeLastZero(getValueString(value)) + " " + unit.getName();
    }

    private void checkNumber(String number) {
        if (!Utils.isNumber(number)) {
            throw new IllegalArgumentException(number + "is not number");
        }
    }

    /**
     * Returns the name of the unit being used
     *
     * @return
     */
    public String getUnitName() {
        return unit.getName();
    }

}
