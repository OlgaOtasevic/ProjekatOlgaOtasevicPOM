package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {



    @Test(priority = 10)
    public void everyUserCanLogIn() {
        for (int i = 1; i < excelReader.getLastRow("Login") - 1; i++) {
            String usernameExcel = excelReader.getStringData("Login", i, 0);
            String passwordExcel = excelReader.getStringData("Login", 1, 1);
            loginPage.usernameField.sendKeys(usernameExcel);
            loginPage.passwordField.sendKeys(passwordExcel);
            loginPage.clickOnLoginButton();

            expectedUrl = excelReader.getStringData("Url", 1, 0);
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

            menuBurger.clickOnMenuBurger();
            menuBurger.clickOnLogoutButton();

        }
    }

    @Test(priority = 20)
    public void lockedOutUserLogInCannotLogIn() {
        String usernameExcel = excelReader.getStringData("Login", excelReader.getLastRow("Login"), 0);
        String passwordExcel = excelReader.getStringData("Login", 1, 1);
        loginPage.usernameField.sendKeys(usernameExcel);
        loginPage.passwordField.sendKeys(passwordExcel);
        loginPage.clickOnLoginButton();

        String errorMessage = "Epic sadface: Sorry, this user has been locked out.";

        Assert.assertEquals(loginPage.errorLogIn.getText(), errorMessage);

    }

    @Test(priority = 30)
    public void lockedOutUserLogInCanLogIn() {
        String usernameExcel = excelReader.getStringData("Login", excelReader.getLastRow("Login"), 0);
        String passwordExcel = excelReader.getStringData("Login", 1, 1);
        loginPage.usernameField.sendKeys(usernameExcel);
        loginPage.passwordField.sendKeys(passwordExcel);
        loginPage.clickOnLoginButton();

        expectedUrl = excelReader.getStringData("Url", 1, 0);
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @Test(priority = 30)
    public void invalidCredentialsUserCannotLogIn() {
        String usernameExcel = excelReader.getStringData("Login", 1, 2);
        String passwordExcel = excelReader.getStringData("Login", 1, 3);
        loginPage.usernameField.sendKeys(usernameExcel);
        loginPage.passwordField.sendKeys(passwordExcel);
        loginPage.clickOnLoginButton();

        //expectedUrl = excelReader.getStringData("Url", 1, 0);
        //Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);

        String errorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.errorLogIn.getText(), errorMessage);

    }
}