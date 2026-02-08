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

    @DisplayName("Выбор кредита в банке")
    @Test
    public void chooseCredit() {

        step("Open bank website", () -> {
            open("https://www.tbank.ru/");
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

    @DisplayName("Выбор страховки в банке")
    @Test
    public void coverageInBank() {
        step("Open bank website", () -> {
            open("");
        });
        step("Click on the buttons", () -> {
            $("[data-test='menu-item-0-title']").hover();
            $("[data-test='clickableArea text-item-3-0']")
                    .shouldBe(visible)
                    .shouldBe(enabled)
                    .shouldBe(interactable)
                    .click();
        });
        step("Verify results text", () -> {
            $$("[data-test='htmlTag title']")
                    .findBy(text("Познакомьтесь со всеми обновлениями приложения "))
                    .shouldBe(visible);
        });
    }

    @DisplayName("Выбор страницы Топливо на веб-сайте банка")
    @Test
    public void fuelInBank() {
        step("Open bank website", () -> {
            open("");
        });
        step("Click on the buttons", () -> {
            $("[data-test='menu-item-0-title']").hover();
            $("[data-test='clickableArea text-item-5-2']")
                    .shouldBe(visible)
                    .shouldBe(enabled)
                    .shouldBe(interactable)
                    .click();
        });
        step("Verify results text", () -> {
            $$("[data-test='htmlTag title']")
                    .findBy(text("Топливо с кэшбэком до 7% в приложении Т‑Банка"))
                    .shouldBe(visible);
        });
    }


}

