package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.demoqa.data.DateGenerator;
import tests.demoqa.pages.widgetsPage.DatePickerPage;
import tests.demoqa.tests.BaseUiTest;

import static com.codeborne.selenide.Condition.value;

@Epic("DemoQA test ui")
@Feature("Widgets")
@Story("Date Picker")
@DisplayName("Тестирование виджета Date Picker")
public class DatePickerTest extends BaseUiTest {
    DatePickerPage datePickerPage = new DatePickerPage();

    @AfterAll
    static void close() {
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void openPage() {
        Selenide.open("date-picker");
    }

    @Test
    @DisplayName("Проверка выбора простой даты")
    @Severity(SeverityLevel.NORMAL)
    public void selectDateTest() {
        String date = DateGenerator.getRandomSimpleDate();
        datePickerPage.selectDate(date);
        datePickerPage.getDate().shouldHave(value(date));
    }

    @Test
    @DisplayName("Проверка выбора даты и времени")
    @Severity(SeverityLevel.NORMAL)
    public void selectDateAndTimeTest() {
        String date = DateGenerator.getRandomDateTime();
        datePickerPage.selectDateAndTime(date);
        datePickerPage.getDateAndTime().shouldHave(value(date));
    }
}