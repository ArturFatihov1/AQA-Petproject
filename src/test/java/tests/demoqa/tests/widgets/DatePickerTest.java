package tests.demoqa.tests.widgets;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.demoqa.data.DateGenerator;
import tests.demoqa.pages.widgetsPage.DatePickerPage;
import tests.demoqa.tests.base.BaseUiTest;

import static com.codeborne.selenide.Condition.value;

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
    public void selectDateTest() {
        String date = DateGenerator.getRandomSimpleDate();
        datePickerPage.selectDate(date);
        datePickerPage.getDate().shouldHave(value(date));
    }

    @Test
    public void selectDateAndTimeTest() {
        String date = DateGenerator.getRandomDateTime();
        datePickerPage.selectDateAndTime(date);
        datePickerPage.getDateAndTime().shouldHave(value(date));
    }
}

