package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.TabsPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

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
    public void openWhatTabTest() {
        tabsPage.openTabWhat()
                .getBodyWhat()
                .shouldHave(text("Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
    }

    @Test
    public void openOriginTabTest() {
        tabsPage.openTabOrigin()
                .getBodyOrigin()
                .shouldHave(text("Contrary to popular belief, Lorem Ipsum is not simply random text."));
    }

    @Test
    public void openUseTabTest() {
        tabsPage.openTabUse()
                .getBodyUse()
                .shouldHave(text("It is a long established fact that a reader will be distracted by the"));
    }

    @Test
    public void oneTabVisibleTest() {
        tabsPage.openTabUse()
                .getBodyUse()
                .shouldHave(text("It is a long established fact that a reader will be distracted by the"));
        tabsPage.getBodyWhat().shouldNotBe(visible);
    }
}
