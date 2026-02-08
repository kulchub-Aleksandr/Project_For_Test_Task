package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PageWebSite {
    private final SelenideElement
            loginButton = $("[data-test='loginButton']"),
            loginFirst = $("[data-test='clickableArea login-first']"),
            formTitle = $("[automation-id='form-title']"),
            phoneInput = $("[automation-id='phone-input']"),
            buttonSubmit = $("[automation-id='button-submit']"),
            serverError = $("[automation-id='server-error']").shouldHave(text("Введен неверный номер телефона"));
    ;

    public PageWebSite openWebSite() {
        open("");
        return this;
    }

    public PageWebSite hoverLoginButton() {
        loginButton.hover();
        return this;

    }

    public PageWebSite loginFirstButton() {
        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        loginFirst.shouldBe(visible)
                .shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindows = WebDriverRunner.getWebDriver().getWindowHandles();
        String newWindow = null;
        for (String handle : allWindows) {
            if (!handle.equals(originalWindow)) {
                newWindow = handle;
                break;
            }
        }
        if (newWindow == null) {
            throw new NoSuchWindowException("Новая вкладка не обнаружена!");
        }
        WebDriverRunner.getWebDriver().switchTo().window(newWindow);
        return this;
    }

    public PageWebSite formTitleValue() {
        formTitle.shouldHave(text("Вход в Т‑Банк"));
        return this;

    }

    public PageWebSite setPhone() {
        phoneInput.setValue("+7 (922) 222-22-2");
        buttonSubmit.click();
        return this;
    }
    public PageWebSite errorValue() {
        serverError.shouldHave(text("Введен неверный номер телефона"));
        return this;
    }


}
