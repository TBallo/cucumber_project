package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.FormPage;

import static org.junit.Assert.assertEquals;

public class formSteps {
    private FormPage formPage;
    public WebDriver driver;

    public formSteps() {
        driver = Hooks.driver;
        formPage = PageFactory.initElements(driver, FormPage.class);
        formPage.setDriver(driver);
    }

    @Given("^I am on task page$")
    public void iAmOnTaskPage() throws Throwable {
        formPage.openPage();
    }

    @When("^I enter number below expected$")
    public void iEnterNumberBelowExpected() throws Throwable {
        formPage.enterNumber(24);
    }

    @And("^I click submit$")
    public void iClickSubmit() throws Throwable {
        formPage.clickOnButton();
    }

    @Then("^I see error message that the number is too small$")
    public void iSeeErrorMessageThatTheNumberIsTooSmall() throws Throwable {
        formPage.getErrorMessage().getCssValue("asd");
        formPage.getErrorMessage().getText();
        assertEquals("Number is too small", formPage.getErrorMessageText());
    }

    @When("^I enter number above expected")
    public void iEnterNumberAboveExpected() throws Throwable {
        formPage.enterNumber(827);
    }

    @Then("^I see error message that the number is too big$")
    public void iSeeErrorMessageThatTheNumberIsTooBig() throws Throwable {
        assertEquals("Number is too big", formPage.getErrorMessageText());
    }
}
