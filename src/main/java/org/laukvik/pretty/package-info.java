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

/**
 * 
 * 
 * A Java library that formats numbers to abbreviated form. E.g format the file size 50.000 as 50 Kb
 * <p>
 * Formatting file sizes
 * <pre>
 * {@code
 * PrettyFormat pretty = new PrettyFormat();
 * pretty.setUnit( ByteUnit.MEGA );
 * pretty.format( new BigDecimal( "2048" ) );  // Returns 2 k
 * }
 * </pre>
 * 
 * Formatting large numbers
 * <pre>
 * {@code
 * PrettyFormat pretty = new PrettyFormat();
 * pretty.setUnit( NumberUnit.MILLION );
 * pretty.format( new BigDecimal( "1234567" ) ); // 1.23 million
 * }
 * </pre>
 * 
 * Formatting with more/less fraction digits
 * <pre>
 * {@code
 * PrettyFormat pretty = new PrettyFormat();
 * pretty.setUnit( NumberUnit.MILLION );
 * pretty.setFractionDigits( 5 );
 * pretty.format( new BigDecimal( "1234567" ) ); // 1.23 million
 * }
 * </pre>
 * 
 * Using preferred unit for bytes
 * <pre>
 * {@code
 * PrettyFormat pretty = new PrettyFormat();
 * pretty.setUnit( ByteUnit.getPreferredUnit( new BigDecimal("185000") ) ); // Sets preferred unit to kilobytes
 * }
 * </pre>
 * 
 * 
 * Using preferred unit for numbers
 * <pre>
 * {@code
 * PrettyFormat pretty = new PrettyFormat();
 * pretty.setUnit( NumberUnit.getPreferredUnit( new BigDecimal("2500000") ) ); // Sets preferred unit to millions
 * }
 * </pre>
 */
package org.laukvik.pretty;

import java.math.BigDecimal;

