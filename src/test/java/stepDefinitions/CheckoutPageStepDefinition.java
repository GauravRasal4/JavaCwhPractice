package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utilities.TestContextSetup;

import java.time.Duration;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;
    public CheckoutPage checkoutPage;
    public WebDriverWait wait;
    public CheckoutPageStepDefinition(TestContextSetup testContextSetup){
        this.testContextSetup= testContextSetup;
        //this.landingPage= new LandingPage(testContextSetup.driver);
        this.checkoutPage=testContextSetup.pageObjectManager.getCheckoutPageObj();
        //wait= testContextSetup.genericUtils.explicitWait();
    }
    public void waitElement(){
        testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    }

    @Then("^User verify that same product (.+) visible in checkout page$")
    public void user_verify_that_same_product_visible_in_checkout_page(String name) {

        String checkProdName= checkoutPage.getProdName().split("-")[0].trim();
        Assert.assertEquals(checkProdName, testContextSetup.landingProdName);
        System.out.println(checkProdName);
    }

    @Then("User apply promo code and place order successfully")
    public void user_apply_promo_code_and_place_order_successfully() {

        //checkoutPage.getEnterPromoCode("Selenium");
        System.out.println("Gaurav");
        checkoutPage.getApplyBtn();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutPage.getPromoInfo()));
        //checkoutPage.getPromoInfo();
        checkoutPage.getPlaceOrder();
    }

}
