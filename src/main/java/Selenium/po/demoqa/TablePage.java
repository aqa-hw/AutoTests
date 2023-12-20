package Selenium.po.demoqa;
import Selenium.base.table.Table;
import Selenium.base.methods.BaseMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static Selenium.base.driver.DriverInit.getDriver;

public class TablePage extends BaseMethods {
    private final By table = By.xpath("//table[@class='ws-table-all']");
    public String tableValue(int rowIndex, int columnIndex){
        WebElement elementTable = getDriver().findElement(table);
       return new Table(elementTable).getValue(rowIndex, columnIndex);
    }
}
