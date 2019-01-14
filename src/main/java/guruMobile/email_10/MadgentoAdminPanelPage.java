package guruMobile.email_10;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MadgentoAdminPanelPage {
    WebDriver driver;

    @FindBy(xpath = "//ul[@id='nav']/descendant::span[1]")
    public WebElement salesButton;

    @FindBy(xpath = "//ul[@id='nav']/descendant::li[2]/child::a")
    public WebElement ordersButton;
    @FindBy(xpath = "//td[@class='export a-right']/child::select")
    public WebElement selectCSV;
    @FindBy(xpath = "//td[@class='export a-right']/child::button")
    public WebElement exportButton;

    public WebElement getExportButton() {
        return exportButton;
    }

    public WebElement getSelectCSV() {
        return selectCSV;
    }

    public WebElement getOrdersButton() {
        return ordersButton;
    }

    public WebElement getSalesButton() {
        return salesButton;
    }

    public MadgentoAdminPanelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
