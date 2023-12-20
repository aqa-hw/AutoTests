package po.demoqa;

import base.methods.BaseMethods;
import org.openqa.selenium.By;

import static base.driver.DriverInit.getDriver;

public class FramePage extends BaseMethods {
    private static final By frameLocator = By.xpath("//iframe[@id='frame1']");
    private static final By headerLocator = By.xpath("//h1[@id='sampleHeading']");
    private static final By frameWrapperText = By.xpath("//div[@id='framesWrapper']/div");

    public FramePage switchToFrame() {
        getDriver().switchTo().frame(getDriver().findElement(frameLocator));
        return this;
    }

    public String getHeaderText() {
        return getDriver().findElement(headerLocator).getText();
    }

    public FramePage switchToDefaultContent() {
        getDriver().switchTo().defaultContent();
        return this;
    }
    public String getFrameText() {
        return getDriver().findElement(frameWrapperText).getText();
    }
}