package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @BeforeMethod
    public void logIn() {
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void logoutTest() {
        menuBurger.clickOnMenuBurger();
        menuBurger.clickOnLogoutButton();
        expectedUrl = excelReader.getStringData("Url", 0, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
