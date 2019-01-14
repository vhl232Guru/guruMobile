package guruMobile.pages;

import guruMobile.UtilsClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageMain_GuruMobile implements Pageable<PageMain_GuruMobile> {

    WebDriver driver;
    @FindBy(xpath = "//*[@class='page-title']")
    private WebElement mainTitle;

    @FindBy(xpath = "//*[@class='level0 nav-1 first']")
    private WebElement mobileButton;
    @FindBy(tagName = "html")
    private WebElement html;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[3]/div/div[4]/ul/li[1]/a")
    private WebElement myAccountButton;
    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/customer/account/']")
    private WebElement accountButton;
    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/customer/account/login/']")
    private WebElement log_in_Button;

    public WebElement getLog_in_Button() {
        return log_in_Button;
    }

    public WebElement getAccountButton() {
        return accountButton;
    }

    public WebElement getMyAccountButton() {
        return myAccountButton;
    }

    public WebElement getHtml() {
        return html;
    }

    public PageMain_GuruMobile(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public WebElement getMainTitle() {
        return mainTitle;
    }

    public WebElement getMobileButton() {
        return mobileButton;
    }

    public PageMain_GuruMobile init() {
        driver.get(UtilsClass.urlGuru);

        return this;
    }

    public boolean isSuitable() {
        return  driver.getCurrentUrl().equals(UtilsClass.urlGuru);
    }


}
