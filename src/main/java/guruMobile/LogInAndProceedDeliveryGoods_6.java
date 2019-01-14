package guruMobile;

import guruMobile.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LogInAndProceedDeliveryGoods_6 {
    WebDriver driver;
    @BeforeClass
    public void setProperty(){
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get(UtilsClass.urlGuru);
    }

    @Test
    public void logInAndProceedGoods() throws IOException {
        Properties properties = new Properties();
        FileInputStream read = new FileInputStream("src/main/resources/data.properties");

        properties.load(read);
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
        String country = properties.getProperty("country");
        String state = properties.getProperty("State");
        String zip = properties.getProperty("zip");
        String address = properties.getProperty("address");
        String city = properties.getProperty("city");
        String telephone = properties.getProperty("telephone");

        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getAccountButton().click();
        pageMain_guruMobile.getLog_in_Button().click();

        PageAccountRegistrationAndLog_in pageAccountRegistrationAndLog_in = new PageAccountRegistrationAndLog_in(driver);
        pageAccountRegistrationAndLog_in.getEmail().sendKeys(email);
        pageAccountRegistrationAndLog_in.getPasswordFild().sendKeys(password);
        pageAccountRegistrationAndLog_in.getLoginButton().click();

        PageClientAccount pageClientAccount = new PageClientAccount(driver);
        pageClientAccount.getAccountButtonWishList().click();
        pageClientAccount.getAccountCart().click();

        //the goods alredy added to cart
        //pageClientAccount.getMyWishListButton().click();
        // MyWishList myWishList = new MyWishList(driver);
        //myWishList.getAddToCart().click();

        CartPage cartPage = new CartPage(driver);
        Select dropCountryCart = new Select(cartPage.getCountryCartChekout());
        dropCountryCart.selectByVisibleText(country);

        Select dropStateCart = new Select(cartPage.getStateCartChekout());
        dropStateCart.selectByVisibleText(state);
        cartPage.getPostcodeCartCheckout().sendKeys(zip);
        cartPage.getEstimateButton().click();

        String flat_rate = cartPage.getFlatRate().getText();
        Assert.assertEquals(flat_rate, UtilsClass.flatRateCost);
        cartPage.getFlatRateButton().click();
        cartPage.getUpdateTotalButton().click();
        String total_cost = cartPage.getGrandTotalCoast().getText();

        Assert.assertEquals(total_cost, UtilsClass.grand_Cost);

        cartPage.getProseedCheckoutButton().click();

        ChekoutPage chekoutPage = new ChekoutPage(driver);
        chekoutPage.getCuntinueBillingButton().click();
        chekoutPage.getAdressForCheckout().sendKeys(address);
        chekoutPage.getCityForCheckout().sendKeys(city);

        Select dropState = new Select(chekoutPage.getSteteForCheckout());
        dropState.selectByVisibleText(state);
        chekoutPage.getZipForCheckout().sendKeys(zip);

        Select dropCountry = new Select(chekoutPage.getCountryForCheckout());
        dropCountry.selectByVisibleText(country);
        chekoutPage.getTlephoneForCheckout().sendKeys(telephone);
        chekoutPage.getContinueButton().click();

        chekoutPage.getCheckMoneyOrder().click();
        chekoutPage.getContinueCheckButton().click();
        chekoutPage.getPlaceOrderButton().click();

        PageConfirnation pageConfirnation = new PageConfirnation(driver);
        String numberOder = pageConfirnation.getNumberOfOreder().getText();
        System.out.println(numberOder);

    }
    @AfterClass
    public void close(){
        driver.quit();
    }

}
