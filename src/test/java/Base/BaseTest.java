package Base;

import Pages.*;
import Tests.LoginTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    public static WebDriver driver;
    public WebDriverWait wdwait;
    public ExcelReader excelReader;
    public String startUrl;
    public String expectedUrl;
    public LoginPage loginPage;
    public CartPage cartPage;
    public ProductsPage productsPage;
    public MenuBurger menuBurger;
    public LoginTest loginTest;
    public List<WebElement> allProducts;
    public CheckOutPage checkOutPage;
    public CheckOutPage2 checkOutPage2;
    public ThankYouPage thankYouPage;


    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        excelReader = new ExcelReader("src\\test\\java\\TestDataSheet.xlsx");
        loginPage = new LoginPage();
        cartPage = new CartPage();
        productsPage = new ProductsPage();
        menuBurger = new MenuBurger();
        loginTest = new LoginTest();
        allProducts = new ArrayList<>();
        checkOutPage = new CheckOutPage();
        checkOutPage2 = new CheckOutPage2();
        thankYouPage = new ThankYouPage();

    }

    @BeforeMethod
    public void pageSetUp() {
        startUrl = excelReader.getStringData("Url", 0, 0);
        driver.navigate().to(startUrl);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE || result.getStatus() == ITestResult.SKIP) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File savedScreenshot = new File("target/screenshots/" + System.currentTimeMillis() + ".jpg");
            FileUtils.copyFile(screenshot, savedScreenshot);
        }
        // driver.quit();
    }

}