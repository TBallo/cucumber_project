package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.io.IOException;

public class GenericPage {
    protected String pageURL;
    private WebDriver driver;

    @FindBy(how = How.TAG_NAME, using = "h1")
    private WebElement header;


    public GenericPage() throws Exception {
        pageURL = "https://kristinek.github.io/test-sample";
    }

    public String getPageHeaderText() {
        return header.getText();
    }

    public void openPage() throws IOException {
        driver.get(pageURL);
    }
}

