package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankTest extends TestBase {

    @DisplayName("Вход в личный кабинет банка")
    @Test
    public void loginInBank() {
        mainPage.openPage()
                .hoverLoginButton()
                .clickLoginFirstButton();
        loginPage.checkFormTitleValue();
    }

    @DisplayName("Вход в личный кабинет банка, используя неполный номер телефона")
    @Test
    public void loginInBankUseIncompletePhoneNumber() {
        mainPage.openPage()
                .hoverLoginButton()
                .clickLoginFirstButton();
        loginPage.setPhone(testData.notFullUserNumber)
                .checkServerErrorValue();

    }

    @DisplayName("Выбор страницы кредита в банке")
    @Test
    public void chooseCredit() {
        mainPage.openPage()
                .clickOnTheCreditsIcon();
        creditPage.checkCreditsTitleValue();

    }

    @DisplayName("Выбор страховки ОСАГО в банке")
    @Test
    public void coverageInBank() {
        mainPage.openPage()
                .hoverOnTheIconPrivatePerson()
                .clickOnTheOsagoIcon();
        osagoPage.checkOsagoTitleValue();

    }

    @DisplayName("Выбор страницы Топливо на веб-сайте банка")
    @Test
    public void fuelInBank() {

        mainPage.openPage()
                .hoverOnTheIconPrivatePerson()
                .clickOnTheFuelIcon();
        fuelPage.checkFuelTitleValue();

    }


}

