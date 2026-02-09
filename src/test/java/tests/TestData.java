package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));
    public String notFullUserNumber = "9" + faker.phoneNumber().subscriberNumber(8);
}
