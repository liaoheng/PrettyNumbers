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

/**
 *
 * @author morten
 */
public enum NumberUnit implements AbstractUnit{

    TEN(1),
    HUNDRED(2),
    THOUSAND(3),
    MILLION(6),
    BILLION(9),
    TRILLION(12),
    QUADRILLION(15),
    QUINTILLION(18),
    SEXTILLION(21),
    SEPTILLION(24),
    OCTILLION(27),
    NONILLION(30),
    DECILLION(33),
    UNDECILLION(36),
    DUODECILLION(39),
    TREDECILLION(42),
    QUATTUORDECILLION(45),
    QUINDECILLION(48),
    SEXDECILLION(51),
    SEPTENDECILLION(54),
    OCTODECILLION(57),
    NOVEMDECILLION(60),
    VIGINTILLION(63);
    
    int multiplier;
    
    private NumberUnit(int multiplier){
        this.multiplier = multiplier;
    }

    @Override
    public int value() {
        return multiplier;
    }
    
    @Override
    public BigDecimal getValue( int index ){
        return new BigDecimal( "10" ).pow( index );
    }
    
    @Override
    public String getName(){
        return name().toLowerCase();
    }
    
}