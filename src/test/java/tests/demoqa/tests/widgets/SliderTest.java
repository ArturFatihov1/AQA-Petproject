package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import tests.demoqa.pages.widgetsPage.SliderPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.value;

@Epic("DemoQA test ui")
@Feature("Widgets")
@Story("Slider")
@DisplayName("Тестирование виджета Slider")
@Flaky
public class SliderTest extends BaseUiTest {
    SliderPage sliderPage = new SliderPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("slider");
    }

    @Test
    @DisplayName("Проверка перемещения слайдера в 0")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    public void moveSliderToZeroTest() {
        sliderPage.moveSlider(-305);
        sliderPage.getSliderValue().shouldHave(value("0"));
    }

    @Test
    @DisplayName("Проверка отсутствия движения при нулевом смещении")
    @Severity(SeverityLevel.TRIVIAL)
    @RetryingTest(3)
    public void notMoveSliderTest() {
        sliderPage.moveSlider(0);
        sliderPage.getSliderValue().shouldHave(value("25"));
    }

    @Test
    @DisplayName("Проверка перемещения слайдера в 100")
    @Severity(SeverityLevel.NORMAL)
    @RetryingTest(3)
    public void moveSliderTo100Test() {
        sliderPage.moveSlider(305);
        sliderPage.getSliderValue().shouldHave(value("100"));
    }
}