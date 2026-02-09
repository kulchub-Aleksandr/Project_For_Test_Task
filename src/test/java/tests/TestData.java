package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en"));
    public String notFullUserNumber = faker.phoneNumber().subscriberNumber(9);
}
