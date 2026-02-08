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

public class PageWebSite {
    private final SelenideElement
            loginButton = $("[data-test='loginButton']"),
            loginFirst = $("[data-test='clickableArea login-first']"),
            formTitle = $("[automation-id='form-title']"),
            phoneInput = $("[automation-id='phone-input']"),
            buttonSubmit = $("[automation-id='button-submit']"),
            serverError = $("[automation-id='server-error']"),
            menuItem0Title = $("[data-test='menu-item-0-title']"),
            textItem_3_0 = $("[data-test='clickableArea text-item-3-0']"),
            textItem_5_2 = $("[data-test='clickableArea text-item-5-2']");


    private final ElementsCollection
            htmlTagTitle = $$("[data-test='htmlTag title']");


    @Step("Открытие первой страницы сайта")
    public PageWebSite openWebSite() {
        open("/");
        return this;
    }

    @Step("Расположить курсор мышки на кнопку \"Личный кабинет\"")
    public PageWebSite hoverLoginButton() {
        loginButton.hover();
        return this;
    }

    @Step("Нажать на кнопку \"Интернет-банк\"")
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

    @Step("Проверить появилась ли надпись \"Вход в Т‑Банк\"")
    public PageWebSite formTitleValue() {
        formTitle.shouldHave(text("Вход в Т‑Банк"));
        return this;
    }

    @Step("Ввести не полный номер телефона")
    public PageWebSite setPhone() {
        phoneInput.setValue("+7 (922) 222-22-2");
        buttonSubmit.click();
        return this;
    }

    @Step("Проверить появилась ли надпись \"Введен неверный номер телефона\"")
    public PageWebSite errorValue() {
        serverError.shouldHave(text("Введен неверный номер телефона"));
        return this;
    }

    @Step("Нажать на иконку \"Кредиты\"")
    public PageWebSite htmlTagTitleCredids() {
        htmlTagTitle.filterBy(exactText("Кредиты"))
                .shouldHave(size(1))
                .first()
                .shouldBe(visible, Duration.ofSeconds(10))
                .click();
        return this;
    }

    @Step("Проверить появилась ли надпись \"Кредиты на любые цели\"")
    public PageWebSite htmlTagTitleValueCredids() {
        htmlTagTitle.findBy(text("Кредиты на любые цели"))
                .shouldBe(visible);
        return this;
    }

    @Step("Расположить курсор мышки на кнопку \"Частным лицам\"")
    public PageWebSite menuItem0Title() {
        menuItem0Title.hover();
        return this;
    }

    @Step("Нажать на строку \"ОСАГО\"")
    public PageWebSite textItem_3_0() {
        textItem_3_0.shouldBe(visible)
                .shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        return this;
    }

    @Step("Проверить появилась ли надпись \"Познакомьтесь со всеми обновлениями приложения\"")
    public PageWebSite htmlTagTitleValueOsago() {
        htmlTagTitle.findBy(text("Познакомьтесь со всеми обновлениями приложения "))
                .shouldBe(visible);
        return this;
    }

    @Step("Нажать на строку \"Топливо\"")
    public PageWebSite textItem_5_2() {
        textItem_5_2.shouldBe(visible)
                .shouldBe(enabled)
                .shouldBe(interactable)
                .click();
        return this;
    }

    @Step("Проверить появилась ли надпись \"Топливо с кэшбэком до 7% в приложении Т‑Банка\"")
    public PageWebSite htmlTagTitleValueFuel() {
        htmlTagTitle.findBy(text("Топливо с кэшбэком до 7% в приложении Т‑Банка"))
                .shouldBe(visible);
        return this;
    }


}
