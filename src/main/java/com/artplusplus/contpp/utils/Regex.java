package com.artplusplus.contpp.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private final static String PATTERN_PHONE_NUMBER = 
        "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

    public static boolean isPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile(PATTERN_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
