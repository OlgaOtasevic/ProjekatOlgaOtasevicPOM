package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends BaseTest {

    public CheckOutPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "first-name")
    public WebElement firstNameFieldCheckout;

    @FindBy(id = "last-name")
    public WebElement lastNameFieldCheckout;

    @FindBy(id = "postal-code")
    public WebElement postalcodeFieldCheckout;

    @FindBy(id = "continue")
    public WebElement continueCheckoutButton;
}
