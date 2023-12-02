import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.awt.*;

import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        driver.manage().window().fullscreen();
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]")).sendKeys("Selenium");
        driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"    ]")).sendKeys(Keys.ENTER);

        //span[text()='Просмотр кода'] - просмотр кода
        //div[@class='main-top-right main-plainlist']//li[1] - создать статью
        //li[@id='pt-anonuserpage']/following-sibling::li[4] - войти

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

}
