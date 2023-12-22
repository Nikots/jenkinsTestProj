package ua.hillel.cases.ui;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import ua.hillel.utils.WebDriverProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseUiTest {

    @BeforeMethod
    public void setup() throws MalformedURLException {
        String browser = System.getProperty("browser", "firefox");
        String hostname = System.getProperty("hostname", "http://localhost:4444");

        URL gridUrl = new URL(hostname + "/wd/hub");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);

        WebDriver driver = new RemoteWebDriver(gridUrl, capabilities);

        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        WebDriverProvider.setDriver(driver);
    }
}
