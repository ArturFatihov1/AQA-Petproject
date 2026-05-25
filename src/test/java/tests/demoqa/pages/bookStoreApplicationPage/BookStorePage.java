package tests.demoqa.pages.bookStoreApplicationPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BookStorePage {
    private final SelenideElement searchBox = $("#searchBox"),
            firstTitle = $x("//tbody/tr/td[2]"),
            description = $("#description-wrapper"),
            backToBookStore = $("#addNewRecordButton");

    @Step("Выполнить поиск книги: {text}")
    public void search(String text) {
        searchBox.setValue(text);
    }

    @Step("Нажать на название первой книги в списке")
    public void clickTitle() {
        firstTitle.click();
    }

    @Step("Вернуться в магазин книг")
    public void back() {
        backToBookStore.click();
    }
}