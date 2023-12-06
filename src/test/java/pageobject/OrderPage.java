package pageobject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class OrderPage {
    public SelenideElement orderButton = $x("//*[@data-name='createOrder-button']");

    // `TODO add fields
}
