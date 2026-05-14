package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OsagoPage {
    private final ElementsCollection
            iuKitButton = $$("[data-qa-type='uikit/button.content']")
            .filterBy(text("Рассчитать"));

    private final SelenideElement
            iuKitErrorBlock = $("[data-qa-type='uikit/formRow.errorBlock']");


    @Step("Проверить появилась ли кнопка \"Рассчитать\"")
    public OsagoPage checkOsagoButtonTitleValue() {
        iuKitButton.first()
                .shouldBe(visible);
        return this;
    }

    @Step("Нажать на кнопку \"Рассчитать\"")
    public OsagoPage pressOsagoButton() {
        iuKitButton.first()
                .click();
        return this;
    }

    @Step("Проверить появилась ли сообщение  \"Поле обязательное\"")
    public OsagoPage checkErrorBlockValue() {
        iuKitErrorBlock.shouldBe(visible);
        return this;
    }
}