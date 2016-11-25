package com.demoqa.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Generators {

    private static String emailFormat = "%s@test.pl";


    public static String setRandomUserName() {
        return RandomStringUtils.randomAlphabetic(10).toLowerCase();
    }


    public static String setRandomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }


    public static String setRandomEmail() {
        String email = String.format(emailFormat, RandomStringUtils.randomAlphabetic(10)).toLowerCase();
        return email;
    }

}
