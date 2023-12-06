package remote;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class LoginRemoteBrowserTest {

    @BeforeAll
    public static void setUpAll(){
        Configuration.remote = "http://34.68.42.160:4444" + "/wd/hub";
        Configuration.browser = "firefox";
        Configuration.browserVersion = "115.0";
        Configuration.browserSize = "1920x1080";

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.<String, Object>of(
                        "enableVNC", true,
                        "enableVideo", true
                ));
    }

    @Test
    public void incorrectCredentialsTest() {

        Selenide.open("http://51.250.6.164:3000/signin");
        sleep(2000);
        $x("//*[@data-name='username-input']").setValue("your_username");
        sleep(2000);
        $x("//*[@data-name='password-input']").setValue("your_password");
        sleep(2000);
        $x("//*[@data-name='signIn-button']").click();
        sleep(2000);
        $x("//*[@data-name='authorizationError-popup']").shouldBe(Condition.exist, Condition.visible);

    }



    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

}
