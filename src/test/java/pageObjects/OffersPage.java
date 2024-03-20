package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;
    public OffersPage(WebDriver driver){
        this.driver= driver;
    }

    By searchProduct = By.cssSelector("#search-field");
    By landingProductName = By.cssSelector("tbody tr td:first-child");

    public void getSearchProduct(String shortName){
        driver.findElement(searchProduct).sendKeys(shortName);
    }
    public String getLandingProductName(){
        return driver.findElement(landingProductName).getText();
    }


}
