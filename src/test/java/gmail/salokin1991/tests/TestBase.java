package gmail.salokin1991.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import gmail.salokin1991.config.CredentialConfig;
import gmail.salokin1991.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {

    public static CredentialConfig credentials =
            ConfigFactory.create(CredentialConfig.class);

    @BeforeAll
    static void beforeAll() {

//            String selenoidUrl = System.getProperty("url", "selenoid.autotests.cloud/wd/hub/");
        String selenoidUrl = System.getProperty("url"); // clean some_test_2 -Durl={'JENKINS_VALUE'}
        String login = credentials.login();
        String password = credentials.password();

        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.startMaximized = true;
        Configuration.remote = format("https://%s:%s@" + selenoidUrl, login, password);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
