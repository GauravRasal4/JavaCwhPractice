package utilities;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {

    public WebDriver driver;
    public String landingProdName;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        this.testBase = new TestBase();
        pageObjectManager= new PageObjectManager(testBase.webDriverManager());
        genericUtils= new GenericUtils(testBase.webDriverManager());
    }
}
