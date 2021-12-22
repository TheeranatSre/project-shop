package com.project.shop.projectshop.utility;

public class StringUtil {
    private StringUtil() {
    }

    public static boolean isNullOrEmpty(String s) {
        return s == null || (s.trim()).isEmpty();
    }
}
