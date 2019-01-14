package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageClientAccount {
    WebDriver driver;
    @FindBy(xpath = "//*[@class='success-msg']")
    private WebElement sucesseMessage;
    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/tv.html']")
    private WebElement tvButtonPageAccount;
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")
    private WebElement myWishListButton;
    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/customer/account/']")
    private WebElement accountButtonWishList;
    @FindBy(xpath = "//*[@id=\"header-account\"]/div/ul/li[3]/a")
    private WebElement accountCart;
    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/sales/order/history/']")
    private WebElement my_Orders;



    public WebElement getMy_Orders() {
        return my_Orders;
    }

    public WebElement getAccountCart() {
        return accountCart;
    }

    public WebElement getAccountButtonWishList() {
        return accountButtonWishList;
    }

    public WebElement getMyWishListButton() {
        return myWishListButton;
    }

    public WebElement getTvButtonPageAccount() {
        return tvButtonPageAccount;
    }

    public WebElement getSucesseMessage() {
        return sucesseMessage;
    }

    public PageClientAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
