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
public class Main {

    public static void main(String[] args) {
        PrettyFormat pretty = new PrettyFormat();
        pretty.setFractionDigits(2);

        pretty.setUnit(ByteUnit.Kb);
        pretty.setFractionDigits(2);
        System.out.println(pretty.format("1234"));

        pretty.setUnit(ByteUnit.getPreferredUnit(new BigDecimal("1234567")));
        System.out.println(pretty.format("1234567"));

//        System.out.println(pretty.format("124124"));
        pretty.setUnit(ByteUnit.Mb);
        System.out.println(pretty.format("256000"));

        pretty.setUnit(NumberUnit.MILLION);
        System.out.println(pretty.format(new BigDecimal("1234567")));

//        pretty.setUnit(ByteUnit.getPreferredUnit(new BigDecimal("1234567")));
//        System.out.println(pretty.format(new BigDecimal("1234567")));
//        pretty.setUnit(ByteUnit.getPreferredUnit(new BigDecimal("1234")));
//
//        System.out.println(pretty.format(new BigDecimal("20123")));
    }

}
