package Tests;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class SocialMedia extends BaseTest {

    @BeforeMethod
    public void logIn() {
        loginPage.usernameField.sendKeys("standard_user");
        loginPage.passwordField.sendKeys("secret_sauce");
        loginPage.clickOnLoginButton();
    }


    @Test
    public void checkSocialMediaIconLinks() {
        WebElement icon = productsPage.twitterIcon;
        Assert.assertTrue(icon.isDisplayed());
        icon.click();
        String twitterUrl = excelReader.getStringData("Url", 2, 0);
        driver.getWindowHandles().forEach(tab -> driver.switchTo().window(tab));
        Assert.assertEquals(driver.getCurrentUrl(), twitterUrl);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(0));

        icon = productsPage.facebookIcon;
        icon.click();
        String facebookUrl = excelReader.getStringData("Url", 3, 0);
        driver.getWindowHandles().forEach(tab2 -> driver.switchTo().window(tab2));
        Assert.assertEquals(driver.getCurrentUrl(), facebookUrl);


        driver.switchTo().window(tabs.get(0));

        productsPage.linkedInIcon.click();
        String linkedInUrl = excelReader.getStringData("Url", 4, 0);
        driver.getWindowHandles().forEach(tab2 -> driver.switchTo().window(tab2));
        Assert.assertEquals(driver.getCurrentUrl(), linkedInUrl);


    }
}
