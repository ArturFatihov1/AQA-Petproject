package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junitpioneer.jupiter.RetryingTest;
import tests.demoqa.data.SliderPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.value;

@Flaky
public class SliderTest extends BaseUiTest {
    SliderPage sliderPage = new SliderPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("slider?");
    }

    @RetryingTest(3)
    public void moveSliderToZeroTest() {
        sliderPage.moveSlider(-305);
        sliderPage.getSliderValue().shouldHave(value("0"));
    }

    @RetryingTest(3)
    public void notMoveSliderTest() {
        sliderPage.moveSlider(0);
        sliderPage.getSliderValue().shouldHave(value("25"));
    }

    @RetryingTest(3)
    public void moveSliderTo100Test() {
        sliderPage.moveSlider(305);
        sliderPage.getSliderValue().shouldHave(value("100"));
    }
}
