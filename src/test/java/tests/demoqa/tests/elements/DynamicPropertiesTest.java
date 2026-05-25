package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.DynamicPropertiesPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.*;

@Epic("DemoQA test ui")
@Feature("Elements")
@Story("Dynamic Properties")
@DisplayName("Тестирование динамических свойств элементов")
public class DynamicPropertiesTest extends BaseUiTest {
    DynamicPropertiesPage dynamicPropertiesPage = new DynamicPropertiesPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("dynamic-properties");
    }

    @Test
    @DisplayName("Проверка активации кнопки через 5 секунд")
    @Severity(SeverityLevel.NORMAL)
    public void willEnabledTest() {
        dynamicPropertiesPage.getEnableAfter().shouldNotBe(enabled);
        dynamicPropertiesPage.shouldBeEnabledAfter(6);
    }

    @Test
    @DisplayName("Проверка появления элемента через 5 секунд")
    @Severity(SeverityLevel.NORMAL)
    public void willVisibleTest() {
        dynamicPropertiesPage.getVisibleAfter().shouldNotBe(visible);
        dynamicPropertiesPage.shouldBeVisibleAfter(6);
    }

    @Test
    @DisplayName("Проверка изменения цвета элемента через 5 секунд")
    @Severity(SeverityLevel.MINOR)
    public void colorChangeTest() {
        dynamicPropertiesPage.getColorChange().shouldNotHave(cssClass("text-danger"));
        dynamicPropertiesPage.shouldChangeColorAfter(6);
    }
}