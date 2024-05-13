package com.example.lib_main.regex_matches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hello {
    public static void main(String[] args) {
        System.out.println("hello regex_matches");
//        timeRegex();
        isPhoneNumber();
    }

    public static void timeRegex() {
        String input = "#2014-03-02,2015-03-02,2016-03-02";
        String regex = "(?<year>\\d{4})-(?<month>\\d{2})-(?<day>\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            System.out.println("-------------------------");
            System.out.println("find:" + matcher.group());
            System.out.println("find year:" + matcher.group("year"));
            System.out.println("find month:" + matcher.group("month"));
            System.out.println("find day:" + matcher.group("day"));
        }
    }

    public static void isPhoneNumber() {
        String input = "18312341234";
        String regex = "^1[3-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println(input + " isPhoneNumber");
        } else {
            System.out.println(input + "is not PhoneNumber");
        }
    }
}
