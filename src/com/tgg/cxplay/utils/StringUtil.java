package com.tgg.cxplay.utils;

public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) ? true : false;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !("".equals(str)) ? true : false;
    }

    public static boolean isEmpty(String str[]) {
        return str == null || str.length < 1 ? true : false;
    }

    public static boolean isNotEmpty(String str[]) {
        return str != null && str.length > 0 ? true : false;
    }

    /**
     * @param src
     * @param str
     * @return str will concat end of src and return the new array.
     * @author Jerry Teng
     */
    public static String[] concat(String[] src, String str) {
        String resultArray[] = new String[src.length + 1];
        System.arraycopy(src, 0, resultArray, 0, src.length);
        resultArray[src.length] = str;
        return resultArray;
    }

    /**
     * @param firstSrc
     * @param secondSrc
     * @return secondSrc will concat end of firstSrc and return the new array.
     * @author Jerry Teng
     */
    public static String[] concat(String[] firstSrc, String[] secondSrc) {
        String resultArray[] = new String[firstSrc.length + secondSrc.length];
        System.arraycopy(firstSrc, 0, resultArray, 0, firstSrc.length);
        System.arraycopy(secondSrc, 0, resultArray, firstSrc.length, secondSrc.length);
        return resultArray;
    }
}
