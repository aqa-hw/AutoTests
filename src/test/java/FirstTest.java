import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class FirstTest {

    private static final By acceptCookie = By.xpath("//button[@id='L2AGLb']");
    private static final By searchInput = By.xpath("//textarea[@class=\"gLFyf\"]");
    private final By firstHeading = By.xpath("//div[@class='Ii9Mbb']");
    private WebDriver driver = null;

    private static final By interactiveDiagrams = By.xpath("//div[@class='Ii9Mbb']");
    @BeforeMethod
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().fullscreen();
        waiter(driver, acceptCookie).click();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    void shouldBeSeleniumDiagram() {

        waiter(driver, searchInput).sendKeys("Selenium");
        waiter(driver, searchInput).sendKeys(Keys.ENTER);
        String text = waiter(driver, firstHeading).getText();
        Assert.assertEquals(text, "Interactive diagrams");

    }
    @Test
    void shouldBeVisibleDiagrams() {
        waiter(driver, searchInput).sendKeys("Selenium");
        waiter(driver, searchInput).sendKeys(Keys.ENTER);
        var text = waiter(driver, interactiveDiagrams).getText();
        Assert.assertEquals("Interactive diagrams", text);
    }

@AfterMethod
void quit() {
    driver.quit();
}
public static WebElement waiter(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
   return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
