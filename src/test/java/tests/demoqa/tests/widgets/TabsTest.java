package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.TabsPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

@Epic("DemoQA test ui")
@Feature("Widgets")
@Story("Tabs")
@DisplayName("Тестирование виджета Tabs")
public class TabsTest extends BaseUiTest {

    TabsPage tabsPage = new TabsPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("tabs");
    }

    @Test
    @DisplayName("Проверка открытия вкладки 'What'")
    @Severity(SeverityLevel.NORMAL)
    public void openWhatTabTest() {
        tabsPage.openTabWhat()
                .getBodyWhat()
                .shouldHave(text("Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
    }

    @Test
    @DisplayName("Проверка открытия вкладки 'Origin'")
    @Severity(SeverityLevel.NORMAL)
    public void openOriginTabTest() {
        tabsPage.openTabOrigin()
                .getBodyOrigin()
                .shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text."));
    }

    @Test
    @DisplayName("Проверка открытия вкладки 'Use'")
    @Severity(SeverityLevel.NORMAL)
    public void openUseTabTest() {
        tabsPage.openTabUse()
                .getBodyUse()
                .shouldHave(text("It is a long established fact that a reader will be distracted by the"));
    }

    @Test
    @DisplayName("Проверка того, что при открытии одной вкладки другие скрыты")
    @Severity(SeverityLevel.NORMAL)
    public void oneTabVisibleTest() {
        tabsPage.openTabUse()
                .getBodyUse()
                .shouldHave(text("It is a long established fact that a reader will be distracted by the"));
        tabsPage.getBodyWhat().shouldNotBe(visible);
    }
}