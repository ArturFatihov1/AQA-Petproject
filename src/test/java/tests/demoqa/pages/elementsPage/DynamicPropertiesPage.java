package tests.demoqa.pages.elementsPage;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

@Getter
public class DynamicPropertiesPage {
    private final SelenideElement enableAfter = $("#enableAfter"),
            colorChange = $("#colorChange"),
            visibleAfter = $("#visibleAfter");

    @Step("Проверить, что кнопка стала активной через {seconds} секунд")
    public void shouldBeEnabledAfter(int seconds) {
        enableAfter.shouldBe(enabled, Duration.ofSeconds(seconds));
    }

    @Step("Проверить, что элемент стал видимым через {seconds} секунд")
    public void shouldBeVisibleAfter(int seconds) {
        visibleAfter.shouldBe(visible, Duration.ofSeconds(seconds));
    }

    @Step("Проверить, что цвет кнопки изменился на красный через {seconds} секунд")
    public void shouldChangeColorAfter(int seconds) {
        colorChange.shouldHave(cssClass("text-danger"), Duration.ofSeconds(seconds));
    }
}