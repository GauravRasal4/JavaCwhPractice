package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    public WebDriver driver;
    public CheckoutPage(WebDriver driver){
        this.driver= driver;
    }

    By prodName= By.cssSelector(".product-name");
    By promoButton = By.cssSelector(".promoBtn");
    By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");

    public String getProdName(){
        return driver.findElement(prodName).getText();
    }
    public void getApplyBtn(){
        driver.findElement(promoButton).click();
    }
    public void getPlaceOrder(){
        driver.findElement(placeOrder).click();
    }

}
