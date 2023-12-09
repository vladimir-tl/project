package allure;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllurePassedTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Allure illustration feature")
    public void annotatedStepTest() {
        Assertions.assertTrue(true);
    }
}
