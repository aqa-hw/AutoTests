package Selenium.base.table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
public class Table {
    WebElement elementTable;
    public Table(WebElement elementTable){
        this.elementTable = elementTable;
    }
    public List<WebElement> getRows(){
        return elementTable.findElements(By.tagName("tr"));

    }
    public List<List<WebElement>> getRowsAndColumns() {
        List<WebElement> rows = getRows();
        List<List<WebElement>> rowsAndColumns = new ArrayList<>();
        for (WebElement row: rows){
            List<WebElement> rowWithColumn = row.findElements(By.tagName("td"));
            rowsAndColumns.add(rowWithColumn);
        }
        return rowsAndColumns;
    }
    public String getValue(int rowNumber, int columnNumber){
        List<List<WebElement>> rowsWithColumns = getRowsAndColumns();
        return rowsWithColumns.get(rowNumber).get(columnNumber - 1).getText();
    }
}
