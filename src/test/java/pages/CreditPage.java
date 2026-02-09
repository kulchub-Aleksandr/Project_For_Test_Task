package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class CreditPage {

    private final ElementsCollection
            htmlTagTitleValueCredits = $$("[data-test='htmlTag title']")
            .filterBy(exactText("Кредиты на любые цели"));


    @Step("Проверить появилась ли надпись \"Кредиты на любые цели\"")
    public CreditPage checkCreditsTitleValue() {
        htmlTagTitleValueCredits.first().shouldBe(visible);
        return this;
    }
}
