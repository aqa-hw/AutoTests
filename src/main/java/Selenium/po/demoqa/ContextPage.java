package Selenium.po.demoqa;

import Selenium.base.methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Selenium.base.driver.DriverInit.getDriver;

public class ContextPage extends BaseMethods {
    public static final By context = By.xpath("//button[@id='rightClickBtn']");
    public static final By doubleC = By.xpath("//button[@id='doubleClickBtn']");
    public ContextPage contextClick(){
        WebElement contextClick = getDriver().findElement(context);
        new Actions(getDriver())
                .contextClick(contextClick).build().perform();
        return this;
    }
    public ContextPage doubleClick(){
        WebElement doubleClick = getDriver().findElement(doubleC);
        new Actions(getDriver())
                .doubleClick(doubleClick).build().perform();
        return this;
    }
    public ContextPage hower(){
        WebElement contextClick1 = getDriver().findElement(context);
        new Actions(getDriver())
                .moveToElement(contextClick1).build().perform();
        return this;
    }
}
