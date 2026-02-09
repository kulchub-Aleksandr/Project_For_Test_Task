package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class FuelPage {

    private final ElementsCollection
            htmlTagTitleValueFuel = $$("[data-test='htmlTag title']")
            .filterBy(text("Топливо с кэшбэком до 7% в приложении Т‑Банка"));

    @Step("Проверить появилась ли надпись \"Топливо с кэшбэком до 7% в приложении Т‑Банка\"")
    public FuelPage checkFuelTitleValue() {
        htmlTagTitleValueFuel.first()
                .shouldBe(visible);
        return this;
    }
}
