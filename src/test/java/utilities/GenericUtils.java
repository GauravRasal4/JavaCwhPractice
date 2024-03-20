package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils {

    public WebDriver driver;
    public WebDriverWait wait;
    public GenericUtils(WebDriver driver){
        this.driver= driver;
    }
    public void switchWindow(){
        Set<String> windowHandle= driver.getWindowHandles();
        Iterator<String> it= windowHandle.iterator();
        String parentWindow= it.next();
        String childWindow= it.next();
        driver.switchTo().window(childWindow);
    }
    public WebDriverWait explicitWait(){
        return wait= new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
