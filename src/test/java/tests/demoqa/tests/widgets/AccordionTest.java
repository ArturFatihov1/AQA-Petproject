package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.AccordionPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

public class AccordionTest extends BaseUiTest {
    AccordionPage accordionPage = new AccordionPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("accordian");
    }

    @Test
    public void firstQuestionClickTest() {
        accordionPage.clickFirst();
        accordionPage.getAccordionBody(0).shouldHave(text("Lorem Ipsum is simply dummy text"));
    }

    @Test
    public void secondQuestionClickTest() {
        accordionPage.clickSecond();
        accordionPage.getAccordionBody(1).shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text"));
    }

    @Test
    public void thirdQuestionClickTest() {
        accordionPage.clickThird();
        accordionPage.getAccordionBody(2).shouldHave(text("It is a long established fact that a reader will be distracted by the readable"));
    }

    @Test
    public void severalQuestionClickTest() {
        accordionPage.clickFirst();
        accordionPage.getAccordionBody(0).shouldHave(text("Lorem Ipsum is simply dummy text"));

        accordionPage.clickSecond();
        accordionPage.getAccordionBody(1).shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text"));
    }
}
