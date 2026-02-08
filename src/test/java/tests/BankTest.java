package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class BankTest extends TestBase {

    @DisplayName("Вход в личный кабинет банка")
    @Test
    public void loginInBank() {
        step("Открытие веб-сайта банка", () -> {
            steps.openWebSite();
        });
        step("Прожатие на соответствующие кнопки", () -> {
            steps.hoverLoginButton();
            steps.loginFirstButton();
        });
        step("Проверка появления соответствующего текста на странице", () -> {
            steps.formTitleValue();
        });
    }

    @DisplayName("Вход в личный кабинет банка, используя неполный номер телефона")
    @Test
    public void loginInBankUseIncompletePhoneNumber() {
        step("Открытие веб-сайта банка", () -> {
            steps.openWebSite();
        });
        step("Прожатие на соответствующие кнопки", () -> {
            steps.hoverLoginButton();
            steps.loginFirstButton();
            steps.setPhone();
        });
        step("Проверка появления соответствующего текста на странице", () -> {
            steps.errorValue();
        });
    }

    @DisplayName("Выбор страницы кредита в банке")
    @Test
    public void chooseCredit() {

        step("Открытие веб-сайта банка", () -> {
            steps.openWebSite();
        });
        step("Прожатие на соответствующие кнопки", () -> {
            steps.htmlTagTitleCredids();
        });
        step("Проверка появления соответствующего текста на странице", () -> {
            steps.htmlTagTitleValueCredids();
        });
    }

    @DisplayName("Выбор страховки ОСАГО в банке")
    @Test
    public void coverageInBank() {
        step("Открытие веб-сайта банка", () -> {
            steps.openWebSite();
        });
        step("Прожатие на соответствующие кнопки", () -> {
            steps.menuItem0Title();
            steps.textItem_3_0();
        });
        step("Проверка появления соответствующего текста на странице", () -> {
            steps.htmlTagTitleValueOsago();
        });
    }

    @DisplayName("Выбор страницы Топливо на веб-сайте банка")
    @Test
    public void fuelInBank() {
        step("Открытие веб-сайта банка", () -> {
            steps.openWebSite();
        });
        step("Прожатие на соответствующие кнопки", () -> {
            steps.menuItem0Title();
            steps.textItem_5_2();
        });
        step("Проверка появления соответствующего текста на странице", () -> {
            steps.htmlTagTitleValueFuel();
        });
    }


}

