package Tests;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddingItemToCart extends BaseTest {

    @BeforeMethod
    public void logIn() {
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
    }


    @Test
    public void addingAllItems(){
        productsPage.addAllItemsToCart();
        Assert.assertTrue(productsPage.cartButton.isDisplayed());

        productsPage.quantityInCart.getText();
        Assert.assertEquals(productsPage.quantityInCart.getText(), "6");


    };


}
