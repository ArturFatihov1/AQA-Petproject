package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class NestedFramesPage {
    private final SelenideElement textInFrame = $("body"),
            textOutFrame = $(".text-center");
}
