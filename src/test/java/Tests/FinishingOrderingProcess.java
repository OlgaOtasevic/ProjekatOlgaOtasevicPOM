package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinishingOrderingProcess extends BaseTest {
    @BeforeMethod
    public void logIn() {
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void wholeOrderingProcess() throws InterruptedException {
        productsPage.addAllItemsToCart();
        productsPage.cartButton.click();
        cartPage.clickOnCheckoutButton();
        checkOutPage.firstNameFieldCheckout.sendKeys("Olga");
        checkOutPage.lastNameFieldCheckout.sendKeys("Otasevic");
        checkOutPage.postalcodeFieldCheckout.sendKeys("11000");
        checkOutPage.continueCheckoutButton.click();

        expectedUrl = "https://www.saucedemo.com/checkout-step-two.html";

        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

        checkOutPage2.finishCheckoutButton.click();

        Assert.assertEquals(thankYouPage.thankYouMessage.getText(), "Thank you for your order!");
    }
}
