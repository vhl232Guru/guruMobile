package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageSonyXperia {

    WebDriver driver;
    @FindBy(id = "product-price-1")
    private WebElement costSonyXperiaPage;

    @FindBy(xpath = "//*[@class='input-text qty']")
    private WebElement quantytiSoniXperia;

    @FindBy(xpath = "//*[@class='button btn-update']")
    private WebElement updateBatton;

    @FindBy(xpath = "//*[@class='error-msg']")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[@class='button2 btn-empty']")
    private WebElement emptyCartButton;

    public WebElement getEmptyCartButton() {
        return emptyCartButton;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    public WebElement getUpdateBatton() {
        return updateBatton;
    }

    public WebElement getQuantytiSoniXperia() {
        return quantytiSoniXperia;
    }

    public WebElement getCostSonyXperiaPage() {
        return costSonyXperiaPage;
    }

    public PageSonyXperia(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
