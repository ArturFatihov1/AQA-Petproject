package tests.demoqa.tests.elements;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Flaky;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junitpioneer.jupiter.RetryingTest;
import tests.demoqa.pages.elementsPage.ButtonsPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

@Flaky
public class ButtonsTest extends BaseUiTest {
    ButtonsPage buttonsPage = new ButtonsPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("buttons");
    }

    @RetryingTest(3)
    public void doubleClickTest() {
        buttonsPage.doubleClick();
        buttonsPage.getDoubleClickMessage().shouldHave(text("You have done a double click"));
    }

    @RetryingTest(3)
    public void rightClickTest() {
        buttonsPage.rightClick();
        buttonsPage.getRightClickMessage().shouldHave(text("You have done a right click"));
    }

    @Test
    public void clickTest() {
        buttonsPage.click();
        buttonsPage.getClickMessage().shouldHave(text("You have done a dynamic click"));
    }

}
