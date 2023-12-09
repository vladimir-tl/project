package allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AllureAnnotationsOriginalTest {

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Allure illustration feature")
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
    @Feature("Allure illustration feature")
    @Severity(SeverityLevel.NORMAL)
    @Disabled
    public void disabledTest() {
    }

    @Test
    @Feature("Feature Exception or Failed")
    public void testWithExceptions() {
        throw new RuntimeException("Exception ...");
    }

    @Test
    @Feature("Feature Exception or Failed")
    public void testFailed() {
        annotatedFirstStep("input data");
        annotatedFailedStep();
    }

    @Step("Annotated failed step ")
    public void annotatedFailedStep() {
        Assertions.fail();
    }
}
