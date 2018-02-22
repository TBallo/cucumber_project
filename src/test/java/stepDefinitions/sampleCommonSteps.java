package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.HomePage;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class sampleCommonSteps {
    private WebDriver driver;
    private HomePage homePage;

    public sampleCommonSteps() {
        this.driver = Hooks.driver;
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Given("^I am on the home page$")
    public void i_am_on_the_home_page() throws Throwable {
        driver.get(homePage.getPageUrl());
    }

    @Then("^I should see home page header$")
    public void i_should_see_home_page_header() throws Throwable {
        assertEquals("This is a home page", homePage.getPageHeaderText());
    }

    @And("^I see a description text$")
    public void iSeeADescriptionText() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
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
}
