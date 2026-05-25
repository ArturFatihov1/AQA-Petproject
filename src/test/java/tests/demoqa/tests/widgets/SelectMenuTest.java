package tests.demoqa.tests.widgets;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import tests.demoqa.pages.widgetsPage.SelectMenuPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SelectMenuTest extends BaseUiTest {

    SelectMenuPage selectMenuPage = new SelectMenuPage();

    @AfterAll
    static void close() {
        closeWebDriver();
    }

    @BeforeEach
    void openPage() {
        open("select-menu");
    }

    @Test
    @DisplayName("Select value")
    @Severity(SeverityLevel.NORMAL)
    void selectValueTest() {
        selectMenuPage.selectValue("Group 2, option 2");
        selectMenuPage.getSelectValueField().shouldHave(text("Group 2, option 2"));
    }

    @Test
    @DisplayName("Select one")
    @Severity(SeverityLevel.NORMAL)
    void selectOneTest() {
        selectMenuPage.selectOne("Mr.");
        selectMenuPage.getSelectOneField().shouldHave(text("Mr."));
    }

    @Test
    @DisplayName("Old Style Select Menu")
    @Severity(SeverityLevel.NORMAL)
    void oldStyleTest() {
        selectMenuPage.oldSelect("3");
        selectMenuPage.getOldSelectResult().shouldHave(text("Yellow"));
    }

    @Test
    @Disabled
    @DisplayName("Multiselect drop down")
    @Severity(SeverityLevel.NORMAL)
    void multiSelectTest() {
        selectMenuPage.multiSelectOption("Green");
        selectMenuPage.getMultiSelectField().shouldHave(text("Green"));

        selectMenuPage.multiSelectOption("Blue");
        selectMenuPage.getMultiSelectField().shouldHave(text("Green")).shouldHave(text("Blue"));

        selectMenuPage.multiSelectRemoveOption("Green");
        selectMenuPage.getMultiSelectField().shouldNotHave(text("Green"));
        selectMenuPage.getMultiSelectField().shouldHave(text("Blue"));

        selectMenuPage.multiSelectRemoveAll();
        selectMenuPage.getMultiSelectField().shouldHave(text("Select..."));
    }

    @Test
    @DisplayName("Standard multi select")
    @Severity(SeverityLevel.NORMAL)
    void standardMultiSelectTest() {
        String car = "saab";
        selectMenuPage.standardMultiSelect(car);
        selectMenuPage.getStandardMultiSelectResult().shouldHave(text("Saab"));
    }
}