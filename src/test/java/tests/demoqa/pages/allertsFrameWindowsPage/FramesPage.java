package tests.demoqa.pages.allertsFrameWindowsPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class FramesPage {
    private final SelenideElement sampleHeading = $("#sampleHeading"),
            frames = $(".text-center");
}
