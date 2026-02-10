package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class OsagoPage {
    private final ElementsCollection
            htmlTagTitleValueOsago = $$("[data-test='htmlTag title']")
            ;

    @Step("Проверить появилась ли надпись \"{value}\"")
    public OsagoPage checkOsagoTitleValue(String value) {
        htmlTagTitleValueOsago.filterBy(text(value))
                .first()
                .shouldBe(visible);
        return this;
    }
}