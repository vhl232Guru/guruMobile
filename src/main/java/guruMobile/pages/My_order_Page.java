package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_order_Page {
    WebDriver driver;

    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/sales/order/view/order_id/7310/']")
    private WebElement view_order;
    @FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr/td[1]")
    private WebElement verifyOrder;
    @FindBy(xpath = "//*[@id=\"my-orders-table\"]/tbody/tr/td[5]")
    private WebElement orderStatus;
    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/sales/order/print/order_id/7310/']")
    private WebElement printOreder;
    @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/sales/order/reorder/order_id/7310/']")
    private WebElement reorder_Link;

    public WebElement getReorder_Link() {
        return reorder_Link;
    }

    public WebElement getPrintOreder() {
        return printOreder;
    }

    public WebElement getOrderStatus() {
        return orderStatus;
    }

    public WebElement getVerifyOrder() {
        return verifyOrder;
    }

    public WebElement getView_order() {
        return view_order;
    }

    public My_order_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
