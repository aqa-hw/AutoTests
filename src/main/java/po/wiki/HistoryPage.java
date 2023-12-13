package po.wiki;

import base.methods.BaseMethods;
import org.openqa.selenium.By;

public class HistoryPage extends BaseMethods {
private static final By historyButton = By.xpath("//li[@id='ca-history']");
private static final By HistoryHeader =By.xpath("//h1[@id='firstHeading']");

public HistoryPage historyButtonClick(){
    click(historyButton);
    return this;
}
    public String getHistoryHeader() {
        return getText(HistoryHeader);
    }
}

