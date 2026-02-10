package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {

    private final ElementsCollection
            htmlTagTitleValueCredits = $$("[data-test='htmlTag title']");


    @Step("Проверить появилась ли надпись \"{value}\"")
    public CreditPage checkCreditsTitleValue(String value) {
        htmlTagTitleValueCredits.filterBy(exactText(value))
                .first()
                .shouldBe(visible);
        return this;
    }
}
