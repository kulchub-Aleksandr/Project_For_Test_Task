package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker2 = new Faker(new Locale("en"));
    public String notFullUserNumber = "9" + faker2.phoneNumber().subscriberNumber(8);
    public String formTitle = "Вход в Т‑Банк";
    public String serverError = "Введен неверный номер телефона";
}
