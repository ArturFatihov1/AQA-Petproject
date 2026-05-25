package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.pages.widgetsPage.AutoCompletePage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.text;

@Epic("DemoQA test ui")
@Feature("Widgets")
@Story("Auto Complete")
@DisplayName("Тестирование виджета Auto Complete")
public class AutoCompleteTest extends BaseUiTest {
    private final String BLACK_COLOR = "Black";
    private final String BLUE_COLOR = "Blue";
    AutoCompletePage autoCompletePage = new AutoCompletePage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("auto-complete");
    }

    @Test
    @DisplayName("Проверка выбора и удаления нескольких элементов")
    @Severity(SeverityLevel.NORMAL)
    public void autoCompleteMultipleTest() {
        autoCompletePage.setAutoCompleteMultipleInput(BLACK_COLOR);
        autoCompletePage.setAutoCompleteMultipleInput(BLUE_COLOR);

        autoCompletePage.getResultMultiple().shouldHave(text(BLACK_COLOR), text(BLUE_COLOR));
        autoCompletePage.removeBlack();
        autoCompletePage.removeBlue();

        autoCompletePage.getResultMultiple().shouldNotHave(text(BLACK_COLOR), text(BLUE_COLOR));
    }

    @Test
    @DisplayName("Проверка удаления всех элементов через кнопку удаления")
    @Severity(SeverityLevel.NORMAL)
    public void multipleRemoveAllTest() {
        autoCompletePage.setAutoCompleteMultipleInput(BLACK_COLOR);
        autoCompletePage.setAutoCompleteMultipleInput(BLUE_COLOR);

        autoCompletePage.getResultMultiple().shouldHave(text(BLACK_COLOR), text(BLUE_COLOR));
        autoCompletePage.removeAll();

        autoCompletePage.getResultMultiple().shouldNotHave(text(BLACK_COLOR), text(BLUE_COLOR));
    }

    @Test
    @DisplayName("Проверка работы поля с одиночным выбором")
    @Severity(SeverityLevel.NORMAL)
    public void autoCompleteSingleTest() {
        autoCompletePage.setAutoCompleteSingleInput(BLACK_COLOR);
        autoCompletePage.getResultSingle().shouldHave(text(BLACK_COLOR));

        autoCompletePage.setAutoCompleteSingleInput(BLUE_COLOR);
        autoCompletePage.getResultSingle().shouldHave(text(BLUE_COLOR));
    }
}