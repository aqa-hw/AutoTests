package Selenium.po.demoqa;

import Selenium.base.methods.BaseMethods;
import org.openqa.selenium.By;

import static Selenium.base.driver.DriverInit.getDriver;

public class AlertPage extends BaseMethods {
    public static final By alertButton = By.xpath("//button[@id='alertButton']");
    public AlertPage alertClick(){
        click(alertButton);
        return this;
    }
    public AlertPage alertAccept(){
        getDriver().switchTo().alert().accept();
        return this;
    }
}
