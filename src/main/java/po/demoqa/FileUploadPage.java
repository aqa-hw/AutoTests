package po.demoqa;

import base.methods.BaseMethods;
import org.openqa.selenium.By;

public class FileUploadPage extends BaseMethods {
    private static final By uploadButton = By.xpath("//input[@id='uploadFile']");
    public FileUploadPage uploadFile(){
        send(uploadButton, "/Users/zodiac/IdeaProjects/Autotests/file.txt");
        return this;
    }
    public FileUploadPage waitFilePath(){
        By xpathLocator = By.xpath("//p[@id='uploadedFilePath']");
        waiter(xpathLocator, 5);
        return this;
    }
}
