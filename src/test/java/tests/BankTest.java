package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BankTest extends TestBase {

    @DisplayName("Вход в личный кабинет банка")
    @Tag("UI")
    @Test
    public void loginInBank() {
        mainPage.openPage()
                .hoverLoginButton()
                .clickLoginFirstButton();
        loginPage.checkFormTitleValue();
    }

    @DisplayName("Вход в личный кабинет банка, используя неполный номер телефона")
    @Tag("UI")
    @Test
    public void loginInBankUseIncompletePhoneNumber() {
        mainPage.openPage()
                .hoverLoginButton()
                .clickLoginFirstButton();
        loginPage.setPhone(testData.notFullUserNumber)
                .checkServerErrorValue();
    }

    @DisplayName("Вход в личный кабинет банка, используя некорректный номер телефона")
    @Tag("UI")
    @Test
    public void loginInBankUseIncorrectPhoneNumberPhoneNumber() {
        mainPage.openPage()
                .hoverLoginButton()
                .clickLoginFirstButton();
        loginPage.setPhone(testData.incorrectPhoneNumber)
                .checkServerErrorValue2();
    }

    @DisplayName("Выбор страницы кредита в банке")
    @Tag("UI")
    @Test
    public void chooseCredit() {
        mainPage.openPage()
                .clickOnTheCreditsIcon();
        creditPage.checkCreditsTitleValue();

    }

    @DisplayName("Выбор страховки ОСАГО в банке")
    @Tag("UI")
    @Test
    public void coverageInBank() {
        mainPage.openPage()
                .hoverOnTheIconPrivatePerson()
                .clickOnTheOsagoIcon();
        osagoPage.checkOsagoButtonTitleValue();
    }

    @DisplayName("Попытка рассчитать страховку ОСАГО без ввода номера автомашины")
    @Tag("UI")
    @Test
    public void coverageInBankWithoutEnteringTheCarNumber() {
        mainPage.openPage()
                .hoverOnTheIconPrivatePerson()
                .clickOnTheOsagoIcon();
        osagoPage.checkOsagoButtonTitleValue()
                .pressOsagoButton()
                .checkErrorBlockValue();
    }

    @DisplayName("Выбор страницы Топливо на веб-сайте банка")
    @Tag("UI")
    @Test
    public void fuelInBank() {
        mainPage.openPage()
                .hoverOnTheIconPrivatePerson()
                .clickOnTheFuelIcon();
        fuelPage.checkFuelTitleValue();
    }

}

