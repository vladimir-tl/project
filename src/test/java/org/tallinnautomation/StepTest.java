package org.tallinnautomation;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;

public class StepTest {

    @Test
    public void annotatedStepTest() {
        annotatedStep("local value");
    }

    @Test
    public void incorrectCredentialsTest() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        Configuration.browserCapabilities = chromeOptions;
        Configuration.browserSize = "1600x1200";
        Configuration.headless = true;

        Selenide.open("http://51.250.6.164:3000/signin");

        $x("//*[@data-name='username-input']").setValue("your_username");
        $x("//*[@data-name='password-input']").setValue("your_password");
        $x("//*[@data-name='signIn-button']").click();
        $x("//*[@data-name='authorizationError-popup']").shouldBe(Condition.exist, Condition.visible);

    }


    @Step("Parent annotated step with parameter [{parameter}]")
    public void annotatedStep(final String parameter) {
        nestedAnnotatedStep();
    }

    @Step("Nested annotated step with global parameter [{this.GLOBAL_PARAMETER}]")
    public void nestedAnnotatedStep() {

    }

}
