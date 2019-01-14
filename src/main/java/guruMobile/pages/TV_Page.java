package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TV_Page {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a")
    private WebElement addToWishListLG;

    public WebElement getAddToWishListLG() {
        return addToWishListLG;
    }

    public TV_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
