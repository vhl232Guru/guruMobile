package guruMobile.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChekoutPage {
    WebDriver driver;
    @FindBy(id = "billing:company")
    private WebElement companyForCheckout;
    @FindBy(id = "billing:street1")
    private WebElement adressForCheckout;
    @FindBy(id = "billing:city")
    private WebElement cityForCheckout;
    @FindBy(id = "billing:postcode")
    private WebElement zipForCheckout;
    @FindBy(id = "billing:telephone")
    private WebElement tlephoneForCheckout;
    @FindBy(id = "billing:country_id")
    private WebElement countryForCheckout;
    @FindBy(id = "billing:region_id")
    private WebElement steteForCheckout;
    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button")
    private WebElement continueButton;
    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button/span/span")
    private WebElement continueButtonFlateRate;
    @FindBy(id = "p_method_checkmo")
    private WebElement checkMoneyOrder;
    @FindBy(xpath = "//*[@id=\"payment-buttons-container\"]/button")
    private WebElement continueCheckButton;
    @FindBy(xpath = "//*[@id=\"review-buttons-container\"]/button")
    private WebElement placeOrderButton;
    @FindBy(xpath = "//*[@id=\"billing-buttons-container\"]/button")
    private WebElement cuntinueBillingButton;
    @FindBy(id = "billing:use_for_shipping_yes")
    private WebElement choiseShipToThisAdress;
    @FindBy(xpath = "//*[@id=\"p_method_checkmo\"]")
    private WebElement choiseCheck_Money;
    @FindBy(xpath = "//*[@id=\"payment-buttons-container\"]/button")
    private WebElement continuePaymentButton;



    public WebElement getContinuePaymentButton() {
        return continuePaymentButton;
    }

    public WebElement getChoiseCheck_Money() {
        return choiseCheck_Money;
    }

    public WebElement getChoiseShipToThisAdress() {
        return choiseShipToThisAdress;
    }

    public WebElement getCuntinueBillingButton() {
        return cuntinueBillingButton;
    }

    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

    public WebElement getCheckMoneyOrder() {
        return checkMoneyOrder;
    }

    public WebElement getContinueCheckButton() {
        return continueCheckButton;
    }

    public WebElement getContinueButtonFlateRate() {
        return continueButtonFlateRate;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getCompanyForCheckout() {
        return companyForCheckout;
    }

    public WebElement getAdressForCheckout() {
        return adressForCheckout;
    }

    public WebElement getCityForCheckout() {
        return cityForCheckout;
    }

    public WebElement getZipForCheckout() {
        return zipForCheckout;
    }

    public WebElement getTlephoneForCheckout() {
        return tlephoneForCheckout;
    }

    public WebElement getCountryForCheckout() {
        return countryForCheckout;
    }

    public WebElement getSteteForCheckout() {
        return steteForCheckout;
    }

    public ChekoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
