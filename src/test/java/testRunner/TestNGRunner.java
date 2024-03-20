package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features =".//src/test/Features", glue ="stepDefinitions", monochrome = true, tags = "@PlaceOrder or @SearchProduct",
        plugin = {"pretty","html:target/Report1.html","json:target/Report2",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:target/failed.txt"})
public class TestNGRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
