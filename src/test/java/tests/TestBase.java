package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        String browser = System.getProperty("browser", "chrome");
        String browserVersion = System.getProperty("browserVersion");
        String baseUrl = System.getProperty("baseUrl", "https://www.tbank.ru/");
        String remoteUrl = System.getProperty("remoteUrl");
        String browserSize = System.getProperty("browserSize");

        Configuration.browserSize = browserSize;
        Configuration.baseUrl = baseUrl;
        Configuration.browser = browser;
        Configuration.browserVersion = browserVersion;
        //Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 10000; // default 4000

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = remoteUrl;
        //"https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();

    }
}
