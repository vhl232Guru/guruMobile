package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button")
    private WebElement proseedCheckoutButton;
    @FindBy(id = "country")
    private WebElement countryCartChekout;
    @FindBy(id = "region_id")
    private WebElement stateCartChekout;
    @FindBy(id = "postcode")
    private WebElement postcodeCartCheckout;
    @FindBy(xpath = "//*[@id=\"shipping-zip-form\"]/div/button")
    private WebElement estimateButton;
    @FindBy(xpath = "//*[@id=\"co-shipping-method-form\"]/dl/dd/ul/li/label")
    private WebElement flatRate;
    @FindBy(name = "estimate_method")
    private WebElement flatRateButton;
    @FindBy(name = "do")
    private WebElement updateTotalButton;
    @FindBy(xpath = "//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]")
    private WebElement grandTotalCoast;
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/input")
    private WebElement q_t_y_numbers;
    @FindBy(xpath = "//*[@id=\"shopping-cart-table\"]/tbody/tr/td[4]/button")
    private WebElement upDate_Button;

    public WebElement getUpDate_Button() {
        return upDate_Button;
    }

    public WebElement getQ_t_y_numbers() {
        return q_t_y_numbers;
    }

    public WebElement getGrandTotalCoast() {
        return grandTotalCoast;
    }

    public WebElement getUpdateTotalButton() {
        return updateTotalButton;
    }

    public WebElement getFlatRateButton() {
        return flatRateButton;
    }

    public WebElement getFlatRate() {
        return flatRate;
    }

    public WebElement getCountryCartChekout() {
        return countryCartChekout;
    }

    public WebElement getStateCartChekout() {
        return stateCartChekout;
    }

    public WebElement getPostcodeCartCheckout() {
        return postcodeCartCheckout;
    }

    public WebElement getEstimateButton() {
        return estimateButton;
    }

    public WebElement getProseedCheckoutButton() {
        return proseedCheckoutButton;
    }

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
