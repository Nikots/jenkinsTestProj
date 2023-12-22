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
        URL gridUrl = new URL("http://192.168.64.2:4444/wd/hub"); // Замініть hostname на адресу сервера Selenium Grid
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("firefox"); // Можете вибрати firefox, chrome тощо

        WebDriver driver = new RemoteWebDriver(gridUrl, capabilities);

        driver.manage().window().setSize(new Dimension(1440, 1100));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        WebDriverProvider.setDriver(driver);
    }
}
