package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import static org.junit.Assert.*;

public class SampleSteps {
    private WebDriver driver;

    public SampleSteps() {
        this.driver = Hooks.driver;
    }

    @Given("^I am on the home page$")
    public void iAmOnTheHomePage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample");
    }

    @Then("^I should see home page header$")
    public void iShouldSeeHomePageHeader() throws Throwable {
        assertEquals("This is a home page",
                driver.findElement(By.cssSelector("h1")).getText());
    }

    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() throws Throwable {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                driver.findElement(By.cssSelector("p")).getText());
    }
    //----------------------------------------------------------------------------------------------
    @When("^I am on page locators$")
    public void iAmOnPageLocators() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }
    //----------------------------------------------------------------------------------------------
    @Then("^I should see a heading text$")
    public void iShouldSeeAHeadingText() throws Throwable {
        assertEquals("Heading 1", driver.findElement(By.cssSelector("#heading_1")).getText());
    }
    //----------------------------------------------------------------------------------------------
    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I change name to \"([^\"]*)\"$")
    public void iChangeNameTo(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @And("^I change age to (\\d+)$")
    public void iChangeAgeTo(int age) throws Throwable {
        String newAge = String.valueOf(age);
        driver.findElement(By.id("age")).sendKeys(String.valueOf(age));
    }

    @Given("^I (?:am on|open) age page$")
    public void iAmOnAgePage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/age");
    }

    @And("^I click submit age$")
    public void iClickSubmitAge() throws Throwable {
        driver.findElement(By.id("submit")).click();
    }

    @Then("^I see message: \"(.*)\"$")
    public void iSeeMessage(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.id("message")).getText());
    }

    @When("^I enter values:$")
    public void iEnterValues(Map<String, String> valuesToEnter) throws Throwable {
        for (Map.Entry<String, String> e : valuesToEnter.entrySet()) {
            driver.findElement(By.id(e.getKey())).clear();
            driver.findElement(By.id(e.getKey())).sendKeys(e.getValue());
        }
    }
    //----------------------------------------------------------------------------------------------

    @Given("^I am on task page$")
    public void iAmOnTaskPage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
    }

    @When("^I enter number (\\d+)$")
    public void iEnterNumber(int num) throws Throwable {
        String numb = String.valueOf(num);
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(numb);
    }

    @And("^I click submit number$")
    public void iClickSubmitNumber() throws Throwable {
        driver.findElement(By.cssSelector(".w3-btn")).click();
    }

    @Then("^I should see an error: \"([^\"]*)\"$")
    public void iShouldSeeAnError(String arg0) throws Throwable {
        driver.findElement(By.id("ch1_error")).isDisplayed();
        assertEquals("Number is too small",driver.findElement(By.id("ch1_error")).getText());
    }


}
