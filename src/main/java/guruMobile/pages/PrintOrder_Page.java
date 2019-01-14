package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintOrder_Page {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"destination-settings\"]/div[2]/button")
    private WebElement changeButton;

    public WebElement getChangeButton() {
        return changeButton;
    }

    public PrintOrder_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
