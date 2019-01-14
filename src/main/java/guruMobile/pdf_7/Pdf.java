package guruMobile.pdf_7;

import guruMobile.UtilsClass;
import guruMobile.pages.My_order_Page;
import guruMobile.pages.PageAccountRegistrationAndLog_in;
import guruMobile.pages.PageClientAccount;
import guruMobile.pages.PageMain_GuruMobile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Pdf {
    WebDriver driver;

    @BeforeClass
    public void setSystem(){
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get(UtilsClass.urlGuru);
    }

    @Test
    public void pdf() throws IOException, InterruptedException {
        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getMyAccountButton().click();

        Properties prop = new Properties();
        FileInputStream read = new FileInputStream("src/main/resources/data.properties");
        prop.load(read);
        String email = prop.getProperty("email");
        String password = prop.getProperty("password");
        PageAccountRegistrationAndLog_in pageAccountRegistrationAndLog_in = new PageAccountRegistrationAndLog_in(driver);
        pageAccountRegistrationAndLog_in.getEmail().sendKeys(email);
        pageAccountRegistrationAndLog_in.getPasswordFild().sendKeys(password);
        pageAccountRegistrationAndLog_in.getLoginButton().click();

        PageClientAccount pageClientAccount = new PageClientAccount(driver);
        pageClientAccount.getMy_Orders().click();



        My_order_Page my_order_page = new My_order_Page(driver);
        String number_Order =  my_order_page.getVerifyOrder().getText();
        String statusOrder = my_order_page.getOrderStatus().getText();

        Assert.assertEquals(UtilsClass.numberOrder,number_Order);
        Assert.assertEquals(UtilsClass.orderStatus,statusOrder);

        my_order_page.getView_order().click();
        my_order_page.getPrintOreder().click();

        String printOederParent = driver.getWindowHandle();
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        //Thread.sleep(3000);
        //driver.close();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //WebElement change =  driver.findElement(By.cssSelector("#destination-settings > div.right-column > button"));
        //change.click();
        Utils.saveInPDF(driver, "test.pdf");

        File file = new File("test.pdf");
        Assert.assertTrue(file.exists() && file.isFile()&& file.length()>0);
        System.out.println(file.length());
        //PrintOrder_Page printOrder_page = new PrintOrder_Page(driver);
        //printOrder_page.getChangeButton().click();

    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
