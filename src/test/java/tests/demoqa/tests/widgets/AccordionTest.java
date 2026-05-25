package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.AccordionPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

@Epic("DemoQA test ui")
@Feature("Widgets")
@Story("Accordion")
@DisplayName("Тестирование виджета Accordion")
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
    @DisplayName("Проверка открытия первого раздела")
    @Severity(SeverityLevel.NORMAL)
    public void firstQuestionClickTest() {
        accordionPage.clickFirst();
        accordionPage.getAccordionBody(0).shouldHave(text("Lorem Ipsum is simply dummy text"));
    }

    @Test
    @DisplayName("Проверка открытия второго раздела")
    @Severity(SeverityLevel.NORMAL)
    public void secondQuestionClickTest() {
        accordionPage.clickSecond();
        accordionPage.getAccordionBody(1).shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text"));
    }

    @Test
    @DisplayName("Проверка открытия третьего раздела")
    @Severity(SeverityLevel.NORMAL)
    public void thirdQuestionClickTest() {
        accordionPage.clickThird();
        accordionPage.getAccordionBody(2).shouldHave(text("It is a long established fact that a reader will be distracted by the readable"));
    }

    @Test
    @DisplayName("Проверка последовательного открытия нескольких разделов")
    @Severity(SeverityLevel.NORMAL)
    public void severalQuestionClickTest() {
        accordionPage.clickFirst();
        accordionPage.getAccordionBody(0).shouldHave(text("Lorem Ipsum is simply dummy text"));

        accordionPage.clickSecond();
        accordionPage.getAccordionBody(1).shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text"));
    }
}