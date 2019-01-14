package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageConfirnation {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div/p[1]")
    private WebElement numberOfOreder;

    public WebElement getNumberOfOreder() {
        return numberOfOreder;
    }

    public PageConfirnation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
