package guruMobile.verifyCannotAdd_3;

import guruMobile.UtilsClass;
import guruMobile.pages.PageMain_GuruMobile;
import guruMobile.pages.PageMobile_2;
import guruMobile.pages.PageSonyXperia;
import guruMobile.pages.ShopingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class VerifycantAddToCart {
    WebDriver driver;

    @BeforeClass
    public void setSystem(){
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get("http://live.guru99.com");
    }

    @Test
    public void varifyCantAdd(){
        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getMobileButton().click();

        PageMobile_2 pageMobile_2 = new PageMobile_2(driver);
        pageMobile_2.getAddToCartSoniXperia().click();

        PageSonyXperia pageSonyXperia = new PageSonyXperia(driver);

        Actions actions = new Actions(driver);
        Action enterQuantity = actions
                .doubleClick(pageSonyXperia.getQuantytiSoniXperia())
                .sendKeys("1000")
                .build();
        enterQuantity.perform();

        pageSonyXperia.getUpdateBatton().click();

        String errorMessageFromPage =  pageSonyXperia.getErrorMessage().getText();
        System.out.println(errorMessageFromPage);

        Assert.assertEquals(UtilsClass.errorMeseg,errorMessageFromPage);

        pageSonyXperia.getEmptyCartButton().click();

        ShopingCart shopingCart = new ShopingCart(driver);

        String messageFromEmtyCart =  shopingCart.getMessage().getText();

        Assert.assertTrue(UtilsClass.messageEmtyCart.equalsIgnoreCase(messageFromEmtyCart));

    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
