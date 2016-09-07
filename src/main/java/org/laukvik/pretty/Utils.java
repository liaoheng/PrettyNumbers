package org.laukvik.pretty;

import java.util.regex.Pattern;

/**
 * @author liaoheng
 * @version 2016-09-07 16:56
 */
public class Utils {

    public static boolean isNumber(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("([0-9]+[.][0-9]+)||([0-9]*)");
        return pattern.matcher(number).matches();
    }

    public static String removeLastZero(String s) {
        String[] split = s.split("\\.");
        if (split.length < 2) {
            return s;
        }
        String zero = split[1];
        while (true) {
            int i = zero.lastIndexOf("0");
            if (zero.isEmpty()) {
                return split[0];
            }
            if (i < (zero.length() - 1)) {
                break;
            }
            zero = zero.substring(0, i);
        }
        return split[0] + "." + zero;
    }
}
