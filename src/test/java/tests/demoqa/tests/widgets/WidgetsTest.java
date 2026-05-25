package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.WidgetsPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

public class WidgetsTest extends BaseUiTest {
    WidgetsPage widgetsPage = new WidgetsPage();

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
        widgetsPage.clickFirst();
        widgetsPage.getAccordionBody(0).shouldHave(text("Lorem Ipsum is simply dummy text"));
    }

    @Test
    public void secondQuestionClickTest() {
        widgetsPage.clickSecond();
        widgetsPage.getAccordionBody(1).shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text"));
    }

    @Test
    public void thirdQuestionClickTest() {
        widgetsPage.clickThird();
        widgetsPage.getAccordionBody(2).shouldHave(text("It is a long established fact that a reader will be distracted by the readable"));
    }

    @Test
    public void severalQuestionClickTest() {
        widgetsPage.clickFirst();
        widgetsPage.getAccordionBody(0).shouldHave(text("Lorem Ipsum is simply dummy text"));

        widgetsPage.clickSecond();
        widgetsPage.getAccordionBody(1).shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text"));
    }
}
