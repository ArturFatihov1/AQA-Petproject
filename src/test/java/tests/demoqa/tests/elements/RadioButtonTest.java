package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.elementsPage.RadioButtonPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.*;

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
    public void selectedYesTest() {
        radioButtonPage.selectYes();
        boolean isSelected = radioButtonPage.getYesRadio().isSelected();
        Assertions.assertTrue(isSelected);
        radioButtonPage.getResult().shouldHave(text("You have selected"), text("Yes"));
    }

    @Test
    public void selectedImpressiveTest() {
        radioButtonPage.selectImpressiveRadio();
        boolean isSelected = radioButtonPage.getImpressiveRadio().isSelected();
        Assertions.assertTrue(isSelected);
        radioButtonPage.getResult().shouldHave(text("You have selected"), text("Impressive"));
    }

    @Test
    public void selectedNoTest() {
        radioButtonPage.getNoRadio().shouldBe(disabled);
        radioButtonPage.getResult().shouldNotBe(visible);
    }

    @Test
    public void nothingSelectedTest() {
        radioButtonPage.getResult().shouldNotBe(visible);
    }
}
