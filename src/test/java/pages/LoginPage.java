package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement
            formTitle = $("[automation-id='form-title']"),
            phoneInput = $("[automation-id='phone-input']"),
            buttonSubmit = $("[automation-id='button-submit']"),
            serverError = $("[automation-id='server-error']");

    @Step("Проверить появилась ли надпись \"{value}\"")
    public LoginPage checkFormTitleValue(String value) {
        formTitle.shouldHave(text(value));
        return this;
    }

    @Step("Ввести не полный номер телефона \"{value}\"")
    public LoginPage setPhone(String value) {
        phoneInput.setValue(value);
        buttonSubmit.click();
        return this;
    }

    @Step("Проверить появилась ли надпись \"{value}\"")
    public LoginPage checkServerErrorValue(String value) {
        serverError.shouldHave(text(value));
        return this;
    }

}
