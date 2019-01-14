package guruMobile.CreatAccountPurchaseOfGoodsSHare_wishlistWithEmail_5;

import guruMobile.UtilsClass;
import guruMobile.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PurchaseGoodsSHareWithEmail {
    WebDriver driver;
    @BeforeClass
    public void setProperty(){
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get(UtilsClass.urlGuru);
    }

    @Test
    public void registerAndPurchaseGoods() throws IOException {
        Properties properties = new Properties();
        FileInputStream read = new FileInputStream("src/main/resources/data.properties");
        properties.load(read);
        String name = properties.getProperty("firstName");
        String middleName = properties.getProperty("MiddleName");
        String lastName = properties.getProperty("LastName");
        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
/*
        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getMyAccountButton().click();

        PageAccountRegistrationAndLog_in account = new PageAccountRegistrationAndLog_in(driver);
        account.getCreatAccountButton().click();

        CreatAccountPage creatAccount = new CreatAccountPage(driver);
        creatAccount.getFirst_name().sendKeys(name);
        creatAccount.getMiddle_name().sendKeys(middleName);
        creatAccount.getLast_name().sendKeys(lastName);
        creatAccount.getEmail_address().sendKeys(email);
        creatAccount.getpASSWORD().sendKeys(password);
        creatAccount.getConfirmPassword().sendKeys(password);
        creatAccount.getRegistrButton().click();

        PageClientAccount pageClientAccount = new PageClientAccount(driver);
        String soccMessagFromAccountPage =  pageClientAccount.getSucesseMessage().getText();
        Assert.assertEquals(soccMessagFromAccountPage,UtilsClass.successMessageAccountPage);
        */
        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getAccountButton().click();
        pageMain_guruMobile.getLog_in_Button().click();

        PageAccountRegistrationAndLog_in account = new PageAccountRegistrationAndLog_in(driver);
        account.getEmail().sendKeys(email);
        account.getPasswordFild().sendKeys(password);
        account.getLoginButton().click();

        PageClientAccount pageClientAccount = new PageClientAccount(driver);
        pageClientAccount.getTvButtonPageAccount().click();
        TV_Page tv_page = new TV_Page(driver);
        tv_page.getAddToWishListLG().click();

        MyWishList myWishList = new MyWishList(driver);
        myWishList.getShereWishlistButton().click();

        ShareWishListPage shareWishListPage = new ShareWishListPage(driver);
        shareWishListPage.getFildToShareEmail().sendKeys("seriislon@gmail.com");
        shareWishListPage.getFildMessage().sendKeys("good tv");
        shareWishListPage.getShareWishListButton().click();

        String success_message_shared_email = myWishList.getSuccessMessageSharedEmail().getText();
        System.out.println(success_message_shared_email);

        Assert.assertEquals(success_message_shared_email, UtilsClass.successMessageSHAREEMAIL);
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
