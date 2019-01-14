package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCart {

    WebDriver driver;

    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement message;
    @FindBy(xpath = "//input[@name='coupon_code']")
    public WebElement discountInputFild;
    @FindBy(xpath = "//div[@class='button-wrapper']")
    public WebElement buttonApply;
    @FindBy(xpath = "//td[@class='a-right']/child::span")
    public WebElement subTotal;
    @FindBy(xpath = "//li[@class='success-msg']/descendant::span")
    public WebElement massedgeSuccess;

    public WebElement getMassedgeSuccess() {
        return massedgeSuccess;
    }

    public WebElement getSubTotal() {
        return subTotal;
    }

    public WebElement getButtonApply() {
        return buttonApply;
    }

    public WebElement getDiscountInputFild() {
        return discountInputFild;
    }

    public WebElement getMessage() {
        return message;
    }

    public ShopingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
