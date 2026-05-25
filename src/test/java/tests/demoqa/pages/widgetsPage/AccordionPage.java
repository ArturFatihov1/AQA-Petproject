package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class AccordionPage {
    private final SelenideElement firstQuestion = $(byText("What is Lorem Ipsum?")),
            secondQuestion = $(byText("Where does it come from?")),
            thirdQuestion = $(byText("Why do we use it?")),
            accordionBody = $(".accordion-body");

    @Step("Нажать на первый заголовок")
    public void clickFirst() {
        firstQuestion.click();
    }

    @Step("Нажать на второй заголовок")
    public void clickSecond() {
        secondQuestion.click();
    }

    @Step("Нажать на третий заголовок")
    public void clickThird() {
        thirdQuestion.click();
    }

    @Step("Получить тело аккордеона под индексом {index}")
    public SelenideElement getAccordionBody(int index) {
        return $$(".accordion-body").get(index);
    }
}