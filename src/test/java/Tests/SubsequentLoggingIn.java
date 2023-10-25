package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubsequentLoggingIn extends BaseTest {
    @Test
    public void multiplelogIn() {
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.tShirtRed.click();
        Assert.assertEquals(productsPage.quantityInCart.getText(), "1");

        menuBurger.burgerMenuButton.click();
        menuBurger.clickOnLogoutButton();


        loginPage.usernameField.sendKeys("problem_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.onesie.click();
        productsPage.bikeLight.click();

        menuBurger.burgerMenuButton.click();
        menuBurger.clickOnLogoutButton();

        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(productsPage.quantityInCart.getText(), "1");

    }
}
