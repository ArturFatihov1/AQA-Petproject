package tests.demoqa.tests.interactions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import tests.demoqa.pages.interactionPages.ResizablePage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("DemoQA test ui")
@Feature("Interactions")
@Story("Resizable")
@DisplayName("Тестирование изменения размера элементов (Resizable)")
public class ResizableTest extends BaseUiTest {
    ResizablePage resizablePage = new ResizablePage();

    @BeforeEach
    void openPage() {
        open("resizable");
    }

    @AfterEach
    void close() {
        closeWebDriver();
    }

    @Step("Выполнить изменение размера на {x} и {y}")
    void resize(int x, int y) {
        SelenideElement holder = resizablePage.getResizeableBox();
        actions().clickAndHold(holder).moveByOffset(x, y).release().perform();
    }

    void assertStyle(String s) {
        String result = resizablePage.getResizeableBoxResult().getAttribute("style");
        assertEquals(s, result);
    }

    @Test
    @DisplayName("Проверка увеличения размера элемента")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    void resizableBoxPositiveTest() {
        resize(100, 50);
        assertEquals("width: 300px; height: 250px;", resizablePage.getResizeableBoxResult().getAttribute("style"));
    }

    @Test
    @DisplayName("Проверка ограничения минимального размера")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    void resizableBoxBelowMinimumTest() {
        resize(-100, -100);
        assertEquals("width: 150px; height: 150px;", resizablePage.getResizeableBoxResult().getAttribute("style"));
    }

    @Test
    @DisplayName("Проверка ограничения максимального размера")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    void resizableBoxAboveMaximumTest() {
        resize(350, 150);
        assertEquals("width: 500px; height: 300px;", resizablePage.getResizeableBoxResult().getAttribute("style"));
    }

    @Test
    @DisplayName("Проверка граничных значений размера")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    void resizableBoxBoundaryTest() {

        resize(-49, -49);
        assertStyle("width: 151px; height: 151px;");
        resize(49, 49);

        resize(-50, -50);
        assertStyle("width: 150px; height: 150px;");
        resize(50, 50);

        resize(-51, -51);
        assertStyle("width: 150px; height: 150px;");
        resize(50, 50);

        resize(299, 99);
        assertStyle("width: 499px; height: 299px;");
        resize(-299, -99);

        resize(300, 200);
        assertStyle("width: 500px; height: 300px;");
        resize(-300, -200);

        resize(301, 201);
        assertStyle("width: 500px; height: 300px;");
        resize(-300, -200);
    }

    @Test
    @DisplayName("Проверка изменения размера свободного элемента")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    void resizableTest() {

        resizablePage.getResizeable().scrollIntoView(true);
        resizablePage.getResizeable().shouldBe(visible);

        Selenide.sleep(500);

        resizablePage.moveElementByOffSet(-200, -200, resizablePage.getResizeable());

        String result = resizablePage.getResizeableResult().getAttribute("style");
        assertEquals("width: 20px; height: 20px;", result);
    }
}
