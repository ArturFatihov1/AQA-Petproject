package tests.demoqa.pages.bookStoreApplicationPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Getter
public class BookStorePage {
    private final SelenideElement searchBox = $("#searchBox"),
            firstTitle = $x("//tbody/tr/td[2]"),
            description = $("#description-wrapper"),
            backToBookStore = $("#addNewRecordButton");

    public void search(String text) {
        searchBox.setValue(text);
    }

    public void clickTitle() {
        firstTitle.click();
    }

    public void back() {
        backToBookStore.click();
    }

}
