package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver= driver;
    }

    By searchProduct = By.cssSelector(".search-keyword");
    By landingProductName = By.xpath("//h4[@class='product-name']");
    By topDealsBtn = By.xpath("//a[contains(text(),'Top Deals')]");
    By cartBtn = By.xpath("//img[@alt='Cart']");
    By proceedCheckout = By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]");
    By incrementBtn = By.cssSelector(".increment");
    By addToCartBtn = By.cssSelector(".product-action button");

    public void getSearchProduct(String shortName){
        driver.findElement(searchProduct).sendKeys(shortName);
    }
    public String getLandingProductName(){
        return driver.findElement(landingProductName).getText();
    }
    public void getTopDealsBtn(){
        driver.findElement(topDealsBtn).click();
    }
    public void getIncrement(int quantity){
        int i =quantity;
        while(i>1){
            driver.findElement(incrementBtn).click();
            i--;
        }
    }
    public void getAddToCartBtn(){
        driver.findElement(addToCartBtn).click();
    }
    public void getCartBtn(){
        driver.findElement(cartBtn).click();
    }
    public void getProceedCheckout(){
        driver.findElement(proceedCheckout).click();
    }
}
