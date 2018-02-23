package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

import static org.junit.Assert.assertEquals;

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

    @When("^I enter name: \"([^\"]*)\"$")
    public void iEnterName(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

    @And("^I enter age: (\\d+)$")
    public void iEnterAge(int age) throws Throwable {
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


    @And("^I should see home page description$")
    public void iShouldSeeHomePageDescription() {
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.", driver.findElement(By.xpath("//p")).getText());
    }

    @When("^I am on page location$")
    public void iAmOnPageLocation() {
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
        assertEquals("https://kristinek.github.io/test-sample/examples/loc", driver.getCurrentUrl());
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^I should see a heading text$")
    public void iShouldSeeAHeadingText() {
        assertEquals("Heading 1", driver.findElement(By.cssSelector("#heading_1")).getText());
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^I am on task page$")
    public void iAmOnTaskPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
        assertEquals("https://kristinek.github.io/test-sample/tasks/task1", driver.getCurrentUrl());
    }

    @When("^I enter number: (\\d+)$")
    public void iEnterNumber(int arg0) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("numb")).sendKeys(String.valueOf(arg0));
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();
    }

    @Then("^I should see an error: \"([^\"]*)\"$")
    public void iShouldSeeAnError(String arg0) {
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
        // Write code here that turns the phrase above into concrete actions
    }
}
