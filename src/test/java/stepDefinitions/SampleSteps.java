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

    @And("^I should see home home page description$")
    public void iShouldSeeHomeHomePageDescription() throws Throwable {
        driver.findElement(By.cssSelector("p")).getText();
    }

    @When("^I am on page locators$")
    public void iAmOnPageLocators() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    @Then("^I should see heading text$")
    public void iShouldSeeHeadingText() throws Throwable {
        assertEquals("Heading 1",
                driver.findElement(By.xpath("//h2[1]")).getText());
    }

    @And("^I changed age to: (\\d+)$")
    public void iChangedAgeTo(int age) throws Throwable {
        String newAge = String.valueOf(age);
        driver.findElements(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys();
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^I changed name to: Tom$")
    public void iChangedNameToTom(String name) throws Throwable {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }


    @Given("^Iam on task page$")
    public void iamOnTaskPage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
    }


    @And("^I enter number: (\\d+)$")
    public void iEnterNumber(int arg) throws Throwable {
        String number = String.valueOf(arg);
        driver.findElement(By.id("numb")).clear();
        driver.findElement(By.id("numb")).sendKeys(number);
        driver.findElement(By.xpath("//*@type='button")).click();
    }

    @Then("^I should see an error: \"([^\"]*)\"$")
    public void iShouldSeeAnError(String error) throws Throwable {
        assertEquals("Number is too small", driver.findElement(By.id("ch1_error")).getText());
    }
}


