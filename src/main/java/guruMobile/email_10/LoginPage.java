package guruMobile.email_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    public WebElement userNameField;
    @FindBy(id = "login")
    public WebElement loginField;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUserNameField() {
        return userNameField;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
