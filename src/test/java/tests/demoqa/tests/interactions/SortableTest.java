package tests.demoqa.tests.interactions;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.interactionPages.SortablePage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class SortableTest extends BaseUiTest {

    SortablePage sortablePage = new SortablePage();

    @AfterAll
    static void close() {
        closeWebDriver();
    }

    @BeforeEach
    void openPage() {
        open("sortable");
    }

    @Test
    public void tabListMoveOneToTwoTest() {
        sortablePage.moveElement(sortablePage.getOneElement(), sortablePage.getTwoElement());
    }

    @Test
    public void tabGridMoveOneToTwoTest() {
        sortablePage.openGridTab();
        sortablePage.moveElement(sortablePage.getOneGridElement(), sortablePage.getTwoGridElement());

    }
}
