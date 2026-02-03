package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class BankTest extends TestBase {

    @DisplayName("Login to the bank's personal account")
    @Test
    public void loginInBank() {

        step("Open bank website", () -> {
            open("");
        });
        step("Click on the buttons", () -> {
            $("[data-test='loginButton']").hover();
            String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
            $("[data-test='clickableArea login-first']")
                    .shouldBe(visible)
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
        });
        step("Verify results text", () -> {
            $("[automation-id='form-title']").shouldHave(text("Вход в Т‑Банк"));

        });
    }

    @DisplayName("Choose credit of bank")
    @Test
    public void chooseCredit() {

        step("Open bank website", () -> {
            open("");
        });
        step("Click on the button", () -> {

            $$("[data-test='htmlTag title']")
                    .filterBy(exactText("Кредиты"))
                    .shouldHave(size(1))
                    .first()
                    .shouldBe(visible, Duration.ofSeconds(10))
                    .click();
        });
        step("Verify results text", () -> {
            $$("[data-test='htmlTag title']")
                    .findBy(text("Кредиты на любые цели"))
                    .shouldBe(visible);
        });
    }

    @DisplayName("Login to the bank using an incomplete phone number")
    @Test
    public void loginInBankUseIncompletePhoneNumber() {

        step("Open bank website", () -> {
            open("");
        });
        step("Click on the buttons", () -> {
            $("[data-test='loginButton']").hover();
            String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
            $("[data-test='clickableArea login-first']")
                    .shouldBe(visible)
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
            $("[automation-id='phone-input']").setValue("+7 (922) 222-22-2");
            $("[automation-id='button-submit']").click();
        });
        step("Verify results text", () -> {
            $("[automation-id='server-error']").shouldHave(text("Введен неверный номер телефона"));

        });
    }
}

