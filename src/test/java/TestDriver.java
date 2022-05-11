import com.celonis.base.BaseTest;
import com.celonis.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.celonis.config.ConfigurationManager.configuration;

public class TestDriver extends BaseTest {
    @Test
    public void testDriver(){
        WebDriver driver = DriverManager.getDriver(configuration().browser());
        driver.get(configuration().url());
    }
}
