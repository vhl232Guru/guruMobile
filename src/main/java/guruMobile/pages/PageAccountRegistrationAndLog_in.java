package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccountRegistrationAndLog_in {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"login-form\"]/div/div[1]/div[2]/a")
    private WebElement creatAccountButton;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement email;
    @FindBy(id = "pass")
    private WebElement passwordFild;
    @FindBy(id = "send2")
    private WebElement loginButton;

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPasswordFild() {
        return passwordFild;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }



    public WebElement getCreatAccountButton() {
        return creatAccountButton;
    }

    public PageAccountRegistrationAndLog_in(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
