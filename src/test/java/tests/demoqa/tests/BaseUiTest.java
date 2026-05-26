package tests.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public abstract class BaseUiTest {

    @BeforeEach
    public void setup() {
        Configuration.browser = "chrome";

        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.browserSize = "1920x1080";

        boolean isRemote = Boolean.parseBoolean(System.getProperty("remote", "false"));

        if (isRemote) {
            String gridUrl = System.getProperty("gridUrl", "http://localhost:4444/wd/hub");
            Configuration.remote = gridUrl;

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            options.setCapability("selenoid:options", Map.of(
                    "enableVNC", true,
                    "enableVideo", true
            ));

            Configuration.browserCapabilities = options;
        }

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false));
    }

    @AfterEach
    public void finish() {
        Selenide.closeWebDriver();
    }
}
