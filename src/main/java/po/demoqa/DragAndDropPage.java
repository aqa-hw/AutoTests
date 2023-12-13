package po.demoqa;

import base.methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static base.driver.DriverInit.getDriver;

public class DragAndDropPage extends BaseMethods {
    public static final By draggable = By.xpath("//div[@id='draggable']");
    public static final By droppable = By.xpath("//div[@id='droppable']");

    public DragAndDropPage dragAndDrop() {
        WebElement draggableElement = getDriver().findElement(draggable);
        WebElement droppableElement = getDriver().findElement(droppable);

        new Actions(getDriver())
                .dragAndDrop(draggableElement, droppableElement)
                .build()
                .perform();

        return this;
    }
}