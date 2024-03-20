package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LandingPage landingPage;
    public OffersPage offersPage;
    public CheckoutPage checkoutPage;
    public PageObjectManager(WebDriver driver){
        this.driver= driver;
    }
    public LandingPage getLandingPageObj(){
        return landingPage= new LandingPage(driver);
    }
    public OffersPage getOffersPageObj(){
        return offersPage= new OffersPage(driver);
    }
    public CheckoutPage getCheckoutPageObj(){
        return checkoutPage= new CheckoutPage(driver);
    }

}
