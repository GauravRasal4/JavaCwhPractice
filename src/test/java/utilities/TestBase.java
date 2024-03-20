package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;
    public WebDriver webDriverManager() throws IOException {
        FileInputStream fis= new FileInputStream(".//src/test/resources/global.properties");
        Properties prop= new Properties();
        prop.load(fis);
        String url= prop.getProperty("URL");
        String browser_prop= prop.getProperty("BROWSER");
        String browser_CMD = System.getProperty("browser");
        String browser;
        if (browser_CMD!=null){
            browser = browser_CMD;
        }
        else {
            browser= browser_prop;
        }

        if (driver==null) {
            if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", ".//src/test/Drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Edge")) {
                System.setProperty("webdriver.edge.driver", ".//src/test/Drivers/msedgedriver.exe");
                driver = new EdgeDriver();
            }
            assert driver != null;
            driver.get(url);
        }
        return driver;
    }
}
