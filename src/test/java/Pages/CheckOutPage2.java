package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage2 extends BaseTest {

    public CheckOutPage2() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    public WebElement finishCheckoutButton;

}
