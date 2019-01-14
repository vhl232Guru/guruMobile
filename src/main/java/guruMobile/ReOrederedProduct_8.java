package guruMobile;

import guruMobile.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReOrederedProduct_8 {
        WebDriver driver;
        @BeforeClass
        public void setProperty(){
            System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
            driver = new ChromeDriver();
            driver.get(UtilsClass.urlGuru);
        }

        @Test
        public void reOrder() throws IOException {
            PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
            pageMain_guruMobile.getMyAccountButton().click();

            String email;
            String password;

            Properties properties = new Properties();
            FileInputStream read = new FileInputStream("src/main/resources/data.properties");
            properties.load(read);
            email = properties.getProperty("email");
            password = properties.getProperty("password");

            PageAccountRegistrationAndLog_in pageAccountRegistrationAndLog_in = new PageAccountRegistrationAndLog_in(driver);
            pageAccountRegistrationAndLog_in.getEmail().sendKeys(email);
            pageAccountRegistrationAndLog_in.getPasswordFild().sendKeys(password);
            pageAccountRegistrationAndLog_in.getLoginButton().click();

            My_order_Page my_order_page = new My_order_Page(driver);
            my_order_page.getReorder_Link().click();

            CartPage cartPage = new CartPage(driver);

            Actions actions = new Actions(driver);
            actions.moveToElement(cartPage.getQ_t_y_numbers()).doubleClick().sendKeys("10").build().perform();
            actions.moveToElement(cartPage.getUpDate_Button()).click().build().perform();

            String newGrandTotal_coast = cartPage.getGrandTotalCoast().getText();
            Assert.assertFalse(UtilsClass.grand_Cost.equalsIgnoreCase(newGrandTotal_coast));
            cartPage.getProseedCheckoutButton().click();

            ChekoutPage chekoutPage = new ChekoutPage(driver);
            chekoutPage.getChoiseShipToThisAdress().click();
            chekoutPage.getCuntinueBillingButton().click();

            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(chekoutPage.getContinueButtonFlateRate())).click();
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(chekoutPage.getChoiseCheck_Money())).click();
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(chekoutPage.getContinuePaymentButton())).click();
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(chekoutPage.getPlaceOrderButton())).click();

            PageConfirnation pageConfirnation = new PageConfirnation(driver);
            String numberOrder = new WebDriverWait(driver,19)
                    .until(ExpectedConditions.visibilityOf( pageConfirnation.getNumberOfOreder())).getText();
            System.out.println(numberOrder);
        }
        @AfterClass
        public void close(){
            driver.quit();
        }
}
