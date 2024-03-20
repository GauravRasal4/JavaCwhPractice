package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utilities.TestContextSetup;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;
    public LandingPage landingPage;
    public LandingPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup= testContextSetup;
        //this.landingPage= new LandingPage(testContextSetup.driver);
        this.landingPage=testContextSetup.pageObjectManager.getLandingPageObj();
    }
    public void waitElement(){
        testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }
    @Given("User is on GreenKart landing page")
    public void User_is_on_GreenKart_landing_page(){


    }
    @When("^User search product with shortname (.+) at landing page and extracted the same product$")
    public void User_search_product_with_shortname_at_landing_page_and_extracted_the_same_product(String shortName) throws InterruptedException {

        //testContextSetup.driver.findElement(By.cssSelector(".search-keyword")).sendKeys(shortName);
        landingPage.getSearchProduct(shortName);
        Thread.sleep(3000);
        testContextSetup.landingProdName= landingPage.getLandingProductName().split("-")[0].trim();
    }
    @When("Added {string} items for same product into cart and proceed to checkout")
    public void Added_items_for_same_product_into_cart_and_proceed_to_checkout(String num) throws InterruptedException {

        landingPage.getIncrement(Integer.parseInt(num));
        landingPage.getAddToCartBtn();
        landingPage.getCartBtn();
        landingPage.getProceedCheckout();
        Thread.sleep(3000);
    }
}
