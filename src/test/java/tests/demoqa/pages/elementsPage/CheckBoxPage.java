package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@NoArgsConstructor
@Getter
public class CheckBoxPage {
    private final SelenideElement switcher = $(".rc-tree-switcher"),
            desktopSwitcher = $x("//span[@aria-label=\"Select Desktop\"]//preceding-sibling::span[@class = \"rc-tree-switcher rc-tree-switcher_close\"]"),
            home = $("[aria-label='Select Home']"),
            desktop = $("[aria-label=\"Select Desktop\"]"),
            documents = $("[aria-label=\"Select Documents\"]"),
            downloads = $("[aria-label=\"Select Downloads\"]"),
            notes = $("[aria-label=\"Select Notes\"]"),
            result = $("#result");

    @Step("click on switcher")
    public CheckBoxPage openSwitcher() {
        switcher.click();
        return this;
    }

    public CheckBoxPage openDesktopSwitcher() {
        desktopSwitcher.click();
        return this;
    }

    @Step("click on home checkbox")
    public CheckBoxPage selectHome() {
        home.click();
        return this;
    }

    @Step("click on inner notes checkbox")
    public CheckBoxPage selectNotes() {
        notes.click();
        return this;
    }
}
