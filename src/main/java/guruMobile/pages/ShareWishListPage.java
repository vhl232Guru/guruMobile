package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShareWishListPage {
    WebDriver driver;
    @FindBy(id = "email_address")
    private WebElement fildToShareEmail;
    @FindBy(id = "message")
    private WebElement fildMessage;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div[2]/button")
    private WebElement shareWishListButton;

    public WebElement getShareWishListButton() {
        return shareWishListButton;
    }

    public WebElement getFildToShareEmail() {
        return fildToShareEmail;
    }

    public WebElement getFildMessage() {
        return fildMessage;
    }

    public ShareWishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
