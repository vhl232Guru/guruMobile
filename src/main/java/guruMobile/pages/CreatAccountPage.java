package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatAccountPage {
    WebDriver driver;
    @FindBy(id = "firstname")
    private WebElement first_name;
    @FindBy(id = "middlename")
    private WebElement middle_name;
    @FindBy(id = "lastname")
    private WebElement last_name;
    @FindBy(id = "email_address")
    private WebElement email_address;
    @FindBy(id = "password")
    private WebElement pASSWORD;
    @FindBy(id = "confirmation")
    private WebElement confirmPassword;
    @FindBy(xpath = "//*[@id=\"form-validate\"]/div[2]/button/span/span")
    private WebElement registrButton;

    public WebElement getFirst_name() {
        return first_name;
    }

    public WebElement getMiddle_name() {
        return middle_name;
    }

    public WebElement getLast_name() {
        return last_name;
    }

    public WebElement getEmail_address() {
        return email_address;
    }

    public WebElement getpASSWORD() {
        return pASSWORD;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getRegistrButton() {
        return registrButton;
    }

    public CreatAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
