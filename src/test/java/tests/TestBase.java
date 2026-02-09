package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    MainPage mainPage = new MainPage();
    LoginPage  loginPage = new LoginPage();
    CreditPage  creditPage = new CreditPage();
    OsagoPage osagoPage = new OsagoPage();
    FuelPage fuelPage = new FuelPage();
    TestData testData = new TestData();

    private static final WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());

    @BeforeAll
    static void beforeAll() {
//        String browser = System.getProperty("browser", "chrome");
//        String browserVersion = System.getProperty("browserVersion");
//        String baseUrl = System.getProperty("baseUrl", "https://www.tbank.ru");
//        String remoteUrl = System.getProperty("remoteUrl");
//        String browserSize = System.getProperty("browserSize");

        Configuration.browserSize = webConfig.browserSize();
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000; // default 4000

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        if (webConfig.isRemote()) {
            Configuration.remote = webConfig.remoteUrl();
        }

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
