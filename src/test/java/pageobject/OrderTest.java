package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import inheritance.BaseSetupApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ApiClient;

import static com.codeborne.selenide.Selenide.open;

public class OrderTest extends BaseSetupApi {

    private static String token;
    OrderPage orderPage = new OrderPage();

    @BeforeAll
    public static void setUpAll() {
        token = ApiClient.getBearerToken();
        Configuration.browserSize = "1280x800";
    }

    @BeforeEach
    public void setUpUi() {
        open(configuration.getString("ui-url"));
        Selenide.localStorage().setItem("jwt", token);
        Selenide.refresh();
    }

    @Test
    public void test(){
        orderPage.orderButton.shouldBe(Condition.visible);
    }
}
