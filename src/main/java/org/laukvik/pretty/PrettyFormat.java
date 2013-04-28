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
 *
 * @author morten
 */
public class PrettyFormat {
    
    private Unit unit;
    private int fractionDigits = 2;
    private BigDecimal unitValue;
    
    public PrettyFormat(){
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
        this.unitValue = unit.getValue( unit.value() );
    }

    public int getFractionDigits() {
        return fractionDigits;
    }

    public void setFractionDigits(int fractionDigits) {
        this.fractionDigits = fractionDigits;
    }
    
    public BigDecimal getValue( BigDecimal value ){
        return value.divide( unitValue  ).setScale( fractionDigits, RoundingMode.FLOOR );
    }
    
    public String format( BigDecimal value ){
        return getValue(value) + " " + unit.getName().toLowerCase();
    }
    

    
}