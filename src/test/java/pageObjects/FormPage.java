package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class FormPage extends GenericPage {
    private WebDriver driver;

    @FindBy(how = How.TAG_NAME, using = "input")
    private WebElement input;
    @FindBy(how = How.TAG_NAME, using = "button")
    private WebElement button;
    @FindBy(how = How.ID, using = "ch1_error")
    private WebElement errorMessage;

    public FormPage() throws Exception{
        super();
        pageURL = pageURL + "/tasks/task1";
    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnButton() {
        button.click();
    }

    public void enterNumber(int number) {
        input.clear();
        input.sendKeys(String.valueOf(number));
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    @Override
    public void openPage() throws IOException {
        driver.get(pageURL);
    }
}
