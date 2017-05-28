package com.demoqa.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Random;

public class Generators {
    static Faker faker = new Faker(new Locale("en"));

    public static String randomEmail() {
        String email = String.format("%s@example.com", RandomStringUtils.randomAlphabetic(8)).toLowerCase();
        return email;
    }

    public static String randomPhoneNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static String randomFirstName() {
        String firstName;
        do {
            firstName = faker.name().firstName();
        } while (firstName.length() < 2);
        return firstName;
    }

    public static String randomName() {
        return faker.pokemon().name();
    }

    public static String randomLastName() {
        return faker.name().lastName();
    }

    public static String randomUrl() {
        return String.format("https://example.com/?%s", RandomStringUtils.randomAlphabetic(10).toLowerCase());
    }

    public static String randomFullName() {
        return faker.name().name();
    }

    public static String randomStreetAddress() {
        return faker.address().streetAddress();
    }

    public static String randomCity() {
        return faker.address().city();
    }

    public static String randomCountyCode() {
        return RandomStringUtils.randomAlphabetic(2).toUpperCase();
    }

    public static String randomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }

    public static double randomAmount() {
        double amount = new Random().nextDouble();
        amount = Math.round(amount * 10000);
        return amount / 100;
    }

    public static String randomPostCode() {
        String postCode = "%s-%s";
        String firstNumbers = RandomStringUtils.randomNumeric(2);
        String secondNumbers = RandomStringUtils.randomNumeric(3);
        return String.format(postCode, firstNumbers, secondNumbers);
    }

    public static String randomBuildingNumber() {
        return faker.address().buildingNumber();
    }

    public static String randomTrackingNumber() {
        return RandomStringUtils.randomNumeric(24);
    }

    public static String generateNip() {

        String nip = "";
        int nipTab[] = new int[10];
        int nipWeights[] = {6, 5, 7, 2, 3, 4, 5, 6, 7};
        int checkDigit;

        do {
            int checkSum = 0;

            for (int position = 0; position < 9; position++) {
                if (position < 3) {
                    nipTab[position] = randomNumber(1, 9);
                } else {
                    nipTab[position] = randomNumber(0, 9);
                }
            }

            for (int position = 0; position < 9; position++) {
                checkSum = (nipTab[position] * nipWeights[position]) + checkSum;
            }

            checkDigit = checkSum % 11;
        } while (checkDigit == 10);

        nipTab[9] = checkDigit;

        for (int number : nipTab) {
            nip = nip + String.valueOf(number);
        }

        return nip;
    }

    private static int randomNumber(int minNumber, int maxNumber) {
        int number;

        if (minNumber > maxNumber) {
            throw new IllegalArgumentException("maxNumber is smaller than minNumber");
        }

        do {
            number = Integer.valueOf(RandomStringUtils.randomNumeric(1));
        } while (number < minNumber || number > maxNumber);

        return number;

    }

}