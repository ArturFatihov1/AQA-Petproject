package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

@Getter
public class BrokenLinksPage {
    private final SelenideElement
            validLink = $("a[href='http://demoqa.com']"),
            brokenLink = $("a[href='http://the-internet.herokuapp.com/status_codes/500']"),
            content = $("#content"),
            brokenImage = $("img[src='/images/Toolsqa_1.jpg']"),
            validImage = $("img[src='/images/Toolsqa.jpg']");

    @Step("Нажать на валидную ссылку")
    public BrokenLinksPage validLinkClick() {
        validLink.click();
        return this;
    }

    @Step("Нажать на битую ссылку")
    public BrokenLinksPage brokenLinkClick() {
        brokenLink.click();
        return this;
    }

    @Step("Получить ширину битого изображения")
    public Long getBrokenImageWidth() {
        brokenImage.shouldBe(visible);
        return executeJavaScript("return arguments[0].naturalWidth", brokenImage.toWebElement());
    }

    @Step("Получить ширину валидного изображения")
    public Long getValidImageWidth() {
        return executeJavaScript("return arguments[0].naturalWidth", validImage.toWebElement());
    }

}
