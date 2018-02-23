import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs {
    @When("^I see a heading text$")
    public void iSeeAHeadingText() throws Throwable {
        driver.get("https://kristinek.github.io/test-sample/examples/loc");

        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
        @Then("^I should see home page header$")
        public void iShouldSeeHomePageHeader () throws Throwable {
            assertEquals("This is a home page",
                    driver.findElement(By.cssSelector("h1")).getText());

        }
    }

}