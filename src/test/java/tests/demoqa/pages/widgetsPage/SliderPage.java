package tests.demoqa.pages.widgetsPage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class SliderPage {
    private final SelenideElement slider = $(".range-slider"),
            sliderValue = $("#sliderValue");

    @Step("Переместить слайдер на {xOffset} пикселей по горизонтали")
    public void moveSlider(int xOffset) {
        Selenide.actions()
                .dragAndDropBy(slider, xOffset, 0)
                .build()
                .perform();
    }
}