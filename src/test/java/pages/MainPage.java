package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement
            loginButton = $("[data-test='loginButton']"),
            loginFirst = $("[data-test='clickableArea login-first']"),
            menuItem0Title = $("[data-test='menu-item-0-title']"),
            textItem_3_0 = $("[data-test='clickableArea text-item-3-0']"),
            textItem_5_2 = $("[data-test='clickableArea text-item-5-2']");


    private final ElementsCollection
            htmlTagTitleCredits = $$("[data-test='htmlTag title']")
            .filterBy(exactText("Кредиты"));

    @Step("Открытие первой страницы сайта")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Расположить курсор мышки на кнопку \"Личный кабинет\"")
    public MainPage hoverLoginButton() {
        loginButton.hover();
        return this;
    }

    @Step("Нажать на кнопку \"Интернет-банк\"")
    public MainPage clickLoginFirstButton() {
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

    @Step("Нажать на иконку \"Кредиты\"")
    public MainPage clickOnTheCreditsIcon() {
        htmlTagTitleCredits.shouldHave(size(1))
                .first()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
        return this;
    }

    @Step("Расположить курсор мышки на кнопку \"Частным лицам\"")
    public MainPage hoverOnTheIconPrivatePerson() {
        menuItem0Title.hover();
        return this;
    }

    @Step("Нажать на строку \"ОСАГО\"")
    public MainPage clickOnTheOsagoIcon() {
        textItem_3_0.shouldBe(visible)
                .shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        return this;
    }

    @Step("Нажать на строку \"Топливо\"")
    public MainPage clickOnTheFuelIcon() {
        textItem_5_2.shouldBe(visible)
                .shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        return this;
    }
}
