package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utilities.TestContextSetup;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class OffersPageStepDefinition {

    public String offerProdName;
    TestContextSetup testContextSetup;
    public OffersPage offersPage;
    public LandingPage landingPage;
    public OffersPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup= testContextSetup;
        this.offersPage= testContextSetup.pageObjectManager.getOffersPageObj();
        this.landingPage= testContextSetup.pageObjectManager.getLandingPageObj();
    }
    public void waitElement() throws IOException {
        testContextSetup.testBase.webDriverManager().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }
    public void switchToWindow(){

        //testContextSetup.driver.findElement(By.xpath("//a[contains(text(),'Top Deals')]")).click();
        landingPage.getTopDealsBtn();
        testContextSetup.genericUtils.switchWindow();
    }

    @Then("^User search same product at offers page with shortname (.+)$")
    public void User_search_same_product_at_offers_page_with_shortname(String shortName) throws IOException {

        switchToWindow();
        waitElement();
        //testContextSetup.driver.findElement(By.cssSelector("#search-field")).sendKeys(shortName);
        offersPage.getSearchProduct(shortName);

    }
    @Then("validate that offers page product matches with landing page product")
    public void validate_that_offers_page_product_matches_with_landing_page_product(){
        offerProdName= offersPage.getLandingProductName();
        Assert.assertEquals(testContextSetup.landingProdName, offerProdName);

    }
}
