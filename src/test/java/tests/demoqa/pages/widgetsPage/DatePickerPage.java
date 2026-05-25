package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DatePickerPage {
    private final SelenideElement date = $("#datePickerMonthYearInput"),
            dateAndTime = $("#dateAndTimePickerInput");

    public void selectDate(String text) {
        date.sendKeys(Keys.CONTROL + "a");
        date.sendKeys(Keys.BACK_SPACE);

        date.setValue(text).pressEnter();
    }

    public void selectDateAndTime(String text) {
        dateAndTime.sendKeys(Keys.CONTROL + "a");
        dateAndTime.sendKeys(Keys.BACK_SPACE);

        dateAndTime.setValue(text).pressEnter();
    }
}
