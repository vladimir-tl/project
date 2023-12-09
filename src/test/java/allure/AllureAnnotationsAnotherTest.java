package allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AllureAnnotationsAnotherTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Allure illustration another feature")
    public void annotatedStepTest() {
        annotatedFirstStep("value as parameter for report");
        annotatedSecondStep();
        thirdStepAsAttachment();
    }

    @Step("Annotated first step with parameter [{parameter}]")
    public void annotatedFirstStep( String parameter) {
    }

    @Step("Annotated second step ")
    public void annotatedSecondStep() {
    }

    @Attachment("attach details")
    private String thirdStepAsAttachment() {
        return "text attachment";
    }

    @Test
    @Feature("Allure illustration another feature")
    @Severity(SeverityLevel.CRITICAL)
    @Disabled
    public void disabledTest() {
    }



    @Step("Annotated failed step ")
    public void annotatedFailedStep() {
        Assertions.fail();
    }
}
