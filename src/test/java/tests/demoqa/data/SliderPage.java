package tests.demoqa.data;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SliderPage {
    private final SelenideElement slider = $(".range-slider"),
            sliderValue = $("#sliderValue");

    public void moveSlider(int xOffset) {
        Selenide.actions()
                .dragAndDropBy(slider, xOffset, 0)
                .build()
                .perform();
    }
}
