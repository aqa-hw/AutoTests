package Selenium;

import Selenium.po.demoqa.*;
import org.testng.annotations.Test;

import static Selenium.base.driver.DriverInit.getDriver;



public class ActionsTest extends BaseTest {

    @Test
    void frameTestInside() {
        getDriver().get("https://demoqa.com/frames");

        String headerText = new FramePage()
                .switchToFrame()
                .getHeaderText();
        System.out.println(headerText);
        String frameText = new FramePage()
                .switchToDefaultContent()
                .getFrameText();
        System.out.println(frameText);
    }


    @Test
    void submitAlerts() {
        getDriver().get("https://demoqa.com/alerts");
        new AlertPage()
                .alertClick()
                .alertAccept();
        }


    @Test
    void dragAndDropTest() {
        getDriver().get("https://demoqa.com/droppable");
            new DragAndDropPage()
                    .dragAndDrop();
   }

    @Test
    void contextAndClickTest() {
        getDriver().get("https://demoqa.com/buttons");
            new ContextPage()
                    .contextClick()
                    .doubleClick()
                    .hower();

    }

    @Test
    void uploadFile() {
        getDriver().get("https://demoqa.com/upload-download");

        new FileUploadPage()
                .uploadFile()
               .waitFilePath();
    }
    @Test
    void getTableColumn(){
        getDriver().get("https://www.w3schools.com/html/html_tables.asp");

        String text = new TablePage().tableValue(3, 3);
        System.out.println(text);
    }

}