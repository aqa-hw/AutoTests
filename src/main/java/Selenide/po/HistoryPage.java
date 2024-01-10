package Selenide.po;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class HistoryPage {
    private SelenideElement historyButton = $x("//li[@id='ca-history']");
    private SelenideElement HistoryHeader = $x("//h1[@id='firstHeading']");

    public HistoryPage historyButtonClick(){
        historyButton.click();
        return page(HistoryPage.class);
    }
    public String getHistoryHeader() {
        return HistoryHeader.getText();

    }
}
