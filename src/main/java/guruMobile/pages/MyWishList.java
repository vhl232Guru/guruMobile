package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishList {
    WebDriver driver;

    @FindBy(name = "save_and_share")
    private WebElement shereWishlistButton;
    @FindBy(xpath = "//*[@class='success-msg']")
    private WebElement successMessageSharedEmail;
    @FindBy(xpath = "//*[@id=\"item_23294\"]/td[5]/div/button")
    private WebElement addToCart;

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getSuccessMessageSharedEmail() {
        return successMessageSharedEmail;
    }

    public MyWishList(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getShereWishlistButton() {
        return shereWishlistButton;
    }
}
