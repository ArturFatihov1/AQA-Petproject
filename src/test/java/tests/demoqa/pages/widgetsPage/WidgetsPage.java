package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class WidgetsPage {
    private final SelenideElement firstQuestion = $(byText("What is Lorem Ipsum?")),
            secondQuestion = $(byText("Where does it come from?")),
            thirdQuestion = $(byText("Why do we use it?")),
            accordionBody = $(".accordion-body");

    public void clickFirst() {
        firstQuestion.click();
    }

    public void clickSecond() {
        secondQuestion.click();
    }

    public void clickThird() {
        thirdQuestion.click();
    }

    public SelenideElement getAccordionBody(int index) {
        return $$(".accordion-body").get(index);
    }
}
