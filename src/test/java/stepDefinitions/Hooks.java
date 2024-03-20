package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContextSetup testContextSetup;
    public Hooks(TestContextSetup testContextSetup){
        this.testContextSetup= testContextSetup;
    }

    @After
    public void closingBrowser() throws IOException {
        testContextSetup.testBase.webDriverManager().quit();
    }
    @AfterStep
    public void addScreenshot(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            WebDriver driver= testContextSetup.testBase.webDriverManager();
            File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] imageToByte= FileUtils.readFileToByteArray(source);
            scenario.attach(imageToByte,"image/jpg","image");
        }
    }

}
