import org.testng.annotations.Test;
import po.demoqa.*;

import static base.driver.DriverInit.getDriver;



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
                .alertClick();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new AlertPage()
                .alertAccept();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }

    @Test
    void dragAndDropTest() {
        getDriver().get("https://demoqa.com/droppable");
            new DragAndDropPage()
                    .dragAndDrop();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
   }

    @Test
    void contextAndClickTest() {
        getDriver().get("https://demoqa.com/buttons");
            new ContextPage()
                    .contextClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            new ContextPage()
                    .doubleClick();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
            new ContextPage()
                    .hower();

    }

    @Test
    void uploadFile() {
        getDriver().get("https://demoqa.com/upload-download");

        new FileUploadPage()
                .uploadFile()
               .waitFilePath();
    }

}