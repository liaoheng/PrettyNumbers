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
 * @author Morten Laukvik
 */
public enum ByteUnit implements Unit{

    b(0), 
    Kb(10), 
    Mb(20), 
    Gb(30),
    Tb(40),
    Pb(50),
    Eb(60),
    Zb(70),
    Yb(80)
    ;
    
    int multiplier;
    
    private ByteUnit(int multiplier){
        this.multiplier = multiplier;
    }

    @Override
    public int value() {
        return multiplier;
    }
    
    private BigDecimal getValue( int index ){
        return new BigDecimal( "2" ).pow( index );
    }

    public BigDecimal getValue() {
        return getValue( multiplier );
    }
    
    public String getName(){
        return name();
    }

    public static ByteUnit getPreferredUnit(BigDecimal value) { 
        ByteUnit foundUnit = ByteUnit.b;
        int x=1;
        for (ByteUnit u : ByteUnit.values()){
            if (value.compareTo( u.getValue() ) == 1 ){
                foundUnit = u;
            }
            x++;
        }
        return foundUnit;
    }


    
}