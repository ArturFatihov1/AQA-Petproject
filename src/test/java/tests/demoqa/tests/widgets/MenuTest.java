package tests.demoqa.tests.widgets;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import tests.demoqa.pages.widgetsPage.MenuPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

@Epic("DemoQA test ui")
@Feature("Widgets")
@Story("Menu")
@DisplayName("Тестирование виджета Menu")
public class MenuTest extends BaseUiTest {

    MenuPage menuPage = new MenuPage();

    @AfterAll
    static void close() {
        closeWebDriver();
    }

    @BeforeEach
    void openPage() {
        open("/menu");
    }

    @Test
    @DisplayName("Проверка раскрытия вложенных меню при наведении")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    void menuTest() {
        menuPage.hoverItem1();
        menuPage.getSubList().shouldNotBe(visible);

        menuPage.hoverItem3();
        menuPage.getSubList().shouldNotBe(visible);

        menuPage.hoverItem2();
        menuPage.getSubList().shouldBe(visible);

        menuPage.hoverSubItem();
        menuPage.getSubSubItem1().shouldBe(visible);
        menuPage.getSubSubItem2().shouldBe(visible);
    }
}