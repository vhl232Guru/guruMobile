package guruMobile.verifyCostGuruMobile_2;

import guruMobile.UtilsClass;
import guruMobile.pages.PageMain_GuruMobile;
import guruMobile.pages.PageMobile_2;
import guruMobile.pages.PageSonyXperia;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class GuruMobileCost {
    WebDriver driver;
    @BeforeClass
    public void setPropery(){
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get("http://live.guru99.com");
    }

    @Test
    public void verifyCost(){
        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getMobileButton().click();

        PageMobile_2 pageMobile_2 = new PageMobile_2(driver);
        String costSoniXperiaMobilePage =  pageMobile_2.getCost().getText();


        pageMobile_2.getSoniXperia().click();

        PageSonyXperia pageSonyXperia = new PageSonyXperia(driver);
        String costFromDetailPage = pageSonyXperia.getCostSonyXperiaPage().getText();
        Assert.assertEquals(costSoniXperiaMobilePage,costFromDetailPage);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
