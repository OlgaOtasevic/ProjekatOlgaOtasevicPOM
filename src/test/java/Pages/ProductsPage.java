package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage extends BaseTest {


    public ProductsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "shopping_cart_container")
    public WebElement cartButton;

    @FindBy(className = "product_sort_container")
    public WebElement sortButton;

    @FindBy(className = "shopping_cart_badge")
    public WebElement quantityInCart;

    @FindBy(className = "product_sort_container")
    public WebElement sortDropdownMenu;

    @FindBy(linkText = "Twitter")
    public WebElement twitterIcon;

    @FindBy(linkText = "Facebook")
    public WebElement facebookIcon;

    @FindBy(linkText = "LinkedIn")
    public WebElement linkedInIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement backpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement bikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement tShirt;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement fleeceJacket;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    public WebElement onesie;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    public WebElement tShirtRed;

    public void addAllItemsToCart(){
        fleeceJacket.click();
        tShirt.click();
        tShirtRed.click();
        onesie.click();
        backpack.click();
        bikeLight.click();
    }
}

/*
   List<WebElement> allItemsList = driver.findElements(By.className("inventory_item_name"));
for (WebElement e : allItemsList)
    System.out.println(e.getAttribute("innerHTML").toLowerCase().replaceAll(" ", "-"));

     */

