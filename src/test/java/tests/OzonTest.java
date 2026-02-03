package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class OzonTest extends TestBase {

    @DisplayName("Display results when searching for Credit")
    @Test
    public void productCreditOzonTest() {

        step("Open bank website", () -> {
            open("");
        });
        step("Click on the search buttons", () -> {
            $(".menu.svelte-122k5y1").$(byText("Все продукты")).hover();
            $(byText("Кредитная карта")).click();
            $("div.text.svelte-179xabn:nth-child(2)").click();

        });
        step("Verify results text", () -> {
            $(".title.svelte-1w3mc3u").shouldHave(text("Оформление кредитной карты"));

        });
    }
    @DisplayName("Registration using an incomplete phone number")
    @Test
    public void registrationWithIncompletePhoneNumber() {

        step("Open bank website", () -> {
            open("");
        });
        step("Click on the input button", () -> {

            $("[data-testid='obi-test-id-borderless-button']")
                    .shouldBe(visible)
                    .shouldBe(enabled)
                    .shouldBe(interactable)
                    .click();
            //$("#layoutPage").shouldHave(text("Введите номер телефона"));
            //$("div.text.svelte-179xabn:nth-child(2)").click();

        });
        step("Verify results text", () -> {
            //$(".title.svelte-1w3mc3u").shouldHave(text("Оформление кредитной карты"));


        });
    }
}

