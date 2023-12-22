package ua.hillel.cases.ui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.ui.pages.LoginPage;
import ua.hillel.ui.pages.MainPage;
import ua.hillel.ui.pages.SecurePage;

import static ua.hillel.utils.WebDriverProvider.getDriver;

public class LoginPomTest extends BaseUiTest {

    @Test
    public void loginTestV1() {
        WebDriver driver = getDriver();
        MainPage mainPage = new MainPage(driver);
        mainPage.openLoginPage();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("tomsmith", "SuperSecretPassword!");

        SecurePage securePage = new SecurePage(driver);
        String secureHeader = securePage.getHeaderText();
        Assert.assertEquals(secureHeader, "Secure Area");
    }

    @Test
    public void loginTestV2() {
        WebDriver driver = getDriver();

        String secureHeader = new MainPage(driver)
                .openLoginPage()
                .setUserName("tomsmith")
                .setPassword("SuperSecretPassword!")
                .submit()
                .getHeaderText();

        Assert.assertEquals(secureHeader, "Secure Area");
    }
}
