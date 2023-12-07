import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SecondTest {

    private static final By firstName = By.xpath("//input[@id='firstname']");
    private static final By lastName = By.xpath("//input[@id='lastname']");
    private static final By userName = By.xpath("//input[@id='userName']");
    private static final By password = By.xpath("//input[@id='password']");
    private static final By newUser = By.xpath("//button[@id='newUser']");
    private static final By logIn = By.xpath("//button[@id='login']");
    private static final By register = By.xpath("//button[@id='register']");
    private static final By invalidPass = By.xpath("//div[@class='col-md-12 col-sm-12']");
    private static final By logOut = By.xpath("//button[text()='Log out']");

    private WebDriver driver = null;


    @BeforeMethod
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        driver.manage().window().fullscreen();

    }

    @Test(dataProvider = "validation_data")
    void invalidLogin(String login, String pwd) {
    waiter(driver, userName).sendKeys(login);
    waiter(driver, password).sendKeys(pwd);
    waiter(driver, logIn).click();
        String text = waiter(driver, invalidPass).getText();
        Assert.assertEquals(text, "Invalid username or password!");

    }

    @Test
    void validLogin() {
        waiter(driver, userName).sendKeys("AutoTester");
        waiter(driver, password).sendKeys("Password@1");
        waiter(driver, logIn).click();
        String text = waiter(driver, logOut).getText();
        Assert.assertEquals(text, "Log out");
        waiter(driver, logOut).click();

    }
    @Test
    void userRegistration() {
        waiter(driver, newUser).click();
        waiter(driver, firstName).sendKeys("Auto");
        waiter(driver, lastName).sendKeys("Tester");
        waiter(driver, userName).sendKeys("AutoTester");
        waiter(driver, password).sendKeys("Password@1");
        new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.rc-anchor-content"))).click();
        driver.switchTo().defaultContent();
        waiter(driver, register).click();

    }



    @AfterMethod
    void quit() {
        driver.quit();
    }

    @DataProvider(name = "validation_data")
    public Object[][] validation() {
        return new Object[][]{
                {"login", "password"},
                {"abra", "cadabra"}
        };
    }
    public static WebElement waiter(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}



