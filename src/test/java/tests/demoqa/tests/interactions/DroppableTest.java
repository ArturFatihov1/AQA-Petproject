package tests.demoqa.tests.interactions;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import org.openqa.selenium.Point;
import tests.demoqa.pages.interactionPages.DroppablePage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@Flaky
public class DroppableTest extends BaseUiTest {
    DroppablePage droppablePage = new DroppablePage();

    @AfterAll
    static void close() {
        closeWebDriver();
    }

    @BeforeEach
    void openPage() {
        open("droppable");
    }

    @Test
    public void simpleDroppableTest() {
        droppablePage.moveElementToElement(droppablePage.getDragMe(), droppablePage.getDroppableSimple());
        droppablePage.getDroppableSimple().shouldHave(text("Dropped!"));
    }

    @Test
    public void acceptDroppableTest() {
        droppablePage.clickAccept();
        droppablePage.moveElementToElement(droppablePage.getNotAcceptable(), droppablePage.getDroppable());
        droppablePage.getDroppable().shouldHave(text("Drop here"));

        droppablePage.moveElementToElement(droppablePage.getAcceptable(), droppablePage.getDroppable());
        droppablePage.getDroppable().shouldHave(text("Dropped!"));
    }


    @RetryingTest(3)
    public void preventDroppableInnerTest() {
        droppablePage.clickPrevent();
        droppablePage.moveElementToElement(droppablePage.getDragBox(), droppablePage.getNotGreedy());
        droppablePage.getNotGreedyResult().shouldNotHave(text("Outer droppable"));

        droppablePage.moveElementToElement(droppablePage.getDragBox(), droppablePage.getGreedy());
        droppablePage.getGreedyResult().shouldHave(text("Outer droppable"));
    }

    @RetryingTest(3)
    public void revertDroppableInnerTest() {
        droppablePage.clickRevert();
        Point revStartLocation = droppablePage.getRevertable().getLocation();
        Point notRevStartLocation = droppablePage.getNotRevertable().getLocation();

        droppablePage.moveElementToElement(droppablePage.getRevertable(), droppablePage.getDropHereRevert());
        droppablePage.moveElementToElement(droppablePage.getNotRevertable(), droppablePage.getDropHereRevert());

        Selenide.sleep(500);

        Point revEndLocation = droppablePage.getRevertable().getLocation();
        Point notRevEndLocation = droppablePage.getNotRevertable().getLocation();

        assertEquals(revStartLocation, revEndLocation);
        assertNotEquals(notRevStartLocation, notRevEndLocation);

    }

}
