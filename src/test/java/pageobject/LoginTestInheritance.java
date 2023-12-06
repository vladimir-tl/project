package pageobject;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import inheritance.BaseSetupApi;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LoginTestInheritance extends BaseSetupApi {

    LoginPage loginPage = new LoginPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUpLoginUi() {
        open( configuration.getString("ui-url") );
    }
    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    public void loginSuccessfullyWithCorrectCredentials() {
        loginPage.login.sendKeys(configuration.getString("username"));
        loginPage.password.sendKeys(configuration.getString("password"));
        loginPage.signInButton.click();
    }
}
