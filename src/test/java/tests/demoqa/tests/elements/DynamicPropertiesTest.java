package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.DynamicPropertiesPage;
import tests.demoqa.tests.base.BaseUiTest;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;

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
    public void willEnabledTest() {
        dynamicPropertiesPage.getEnableAfter().shouldNotBe(enabled);
        dynamicPropertiesPage.getEnableAfter().shouldBe(enabled, Duration.ofSeconds(6));
    }

    @Test
    public void willVisibleTest() {
        dynamicPropertiesPage.getVisibleAfter().shouldNotBe(visible);
        dynamicPropertiesPage.getVisibleAfter().shouldBe(visible, Duration.ofSeconds(6));
    }

    @Test
    public void colorChangeTest() {
        dynamicPropertiesPage.getColorChange().shouldNotHave(cssClass("text-danger"));
        dynamicPropertiesPage.getColorChange().shouldHave(cssClass("text-danger"), Duration.ofSeconds(6));
    }

}
