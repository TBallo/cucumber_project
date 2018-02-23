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

    @When("^I am on page Locators$")
    public void IamonpageLocators() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/loc");
    }

    @Given("^I am on task page$")
    public void Iamontaskpage() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/tasks/task1");
    }

    @When("^I enter number: (\\d+)$")
    public void Ienternumber35(String number) throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"numb\"]")).clear();
        driver.findElement(By.xpath("//*[@id=\"numb\"]")).sendKeys(number);
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/button")).click();

    }
    @Then("^I should see an error: \"Number is too small\"$")
    public void IshouldseeanerrorNumberistoosmall() throws Throwable {
        assertEquals("Number is too small",
                driver.findElement(By.xpath("//*[@id=\"ch1_error\"]")).getText());}







    @Then("^I should see a heading text$")
    public void Ishouldseeaheadingtext() throws Throwable {
        assertEquals("Heading 1",
                driver.findElement(By.xpath("//*[@id=\"heading_1\"]")).getText());
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
    @And("^I change age to 6$")
    public void Ichangeageto6() throws Throwable {
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
}
