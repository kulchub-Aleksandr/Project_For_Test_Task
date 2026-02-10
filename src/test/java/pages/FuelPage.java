package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class FuelPage {

    private final ElementsCollection
            htmlTagTitleValueFuel = $$("[data-test='htmlTag title']");

    @Step("Проверить появилась ли надпись \"{value}\"")
    public FuelPage checkFuelTitleValue(String value) {
        htmlTagTitleValueFuel.filterBy(text(value))
                .first()
                .shouldBe(visible);
        return this;
    }
}
