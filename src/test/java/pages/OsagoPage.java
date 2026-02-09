package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class OsagoPage {
    private final ElementsCollection
            htmlTagTitleValueOsago = $$("[data-test='htmlTag title']")
            .filterBy(text("Познакомьтесь со всеми обновлениями приложения "));

    @Step("Проверить появилась ли надпись \"Познакомьтесь со всеми обновлениями приложения\"")
    public OsagoPage checkOsagoTitleValue() {
        htmlTagTitleValueOsago.first()
                .shouldBe(visible);
        return this;
    }
}