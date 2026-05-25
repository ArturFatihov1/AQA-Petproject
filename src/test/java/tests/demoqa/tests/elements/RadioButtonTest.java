package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.RadioButtonPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.*;

@Epic("DemoQA test ui")
@Feature("Elements")
@Story("Radio Button")
@DisplayName("Тестирование переключателей (Radio Buttons)")
public class RadioButtonTest extends BaseUiTest {

    RadioButtonPage radioButtonPage = new RadioButtonPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("radio-button");
    }

    @Test
    @DisplayName("Проверка выбора переключателя Yes")
    @Severity(SeverityLevel.NORMAL)
    public void selectedYesTest() {
        radioButtonPage.selectYes();
        radioButtonPage.getYesRadio().shouldBe(selected);
        radioButtonPage.getResult().shouldHave(text("You have selected"), text("Yes"));
    }

    @Test
    @DisplayName("Проверка выбора переключателя Impressive")
    @Severity(SeverityLevel.NORMAL)
    public void selectedImpressiveTest() {
        radioButtonPage.selectImpressiveRadio();
        radioButtonPage.getImpressiveRadio().shouldBe(selected);
        radioButtonPage.getResult().shouldHave(text("You have selected"), text("Impressive"));
    }

    @Test
    @DisplayName("Проверка, что переключатель No заблокирован")
    @Severity(SeverityLevel.TRIVIAL)
    public void selectedNoTest() {
        radioButtonPage.getNoRadio().shouldBe(disabled);
        radioButtonPage.getResult().shouldNotBe(visible);
    }

    @Test
    @DisplayName("Проверка отсутствия выбора по умолчанию")
    @Severity(SeverityLevel.TRIVIAL)
    public void nothingSelectedTest() {
        radioButtonPage.getResult().shouldNotBe(visible);
    }
}
