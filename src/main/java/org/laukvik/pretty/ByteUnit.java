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
public enum ByteUnit implements Unit{

    BYTE(0), 
    KILO(10), 
    MEGA(20), 
    GIGA(30),
    TERA(40),
    PETA(50),
    EXA(60),
    ZETTA(70),
    YOTTA(80)
    ;
    
    int multiplier;
    
    private ByteUnit(int multiplier){
        this.multiplier = multiplier;
    }

    @Override
    public int value() {
        return multiplier;
    }
    
    public BigDecimal getValue( int index ){
        return new BigDecimal( "2" ).pow( index );
    }
    
    public String getName(){
        return name().toLowerCase();
    }
    
}