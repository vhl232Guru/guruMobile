package guruMobile.compareTwoProduct_4;

import guruMobile.UtilsClass;
import guruMobile.pages.PageMain_GuruMobile;
import guruMobile.pages.PageMobile_2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CompareProduct {

    WebDriver driver;

    @BeforeClass
    public void setProperty(){
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get(UtilsClass.urlGuru);
    }

    @Test
    public void compere(){
        PageMain_GuruMobile pageMain_guruMobile = new PageMain_GuruMobile(driver);
        pageMain_guruMobile.getMobileButton().click();

        PageMobile_2 pageMobile_2 = new PageMobile_2(driver);
        pageMobile_2.getCompareSonyXperia().click();
        pageMobile_2.getCompareIPHONE().click();

        pageMobile_2.getCompareButton().click();

//not my
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window
        // Now you are in the popup window, perform necessary actions here
// again my
        WebElement titleComperePopUpWindow = driver.findElement(By.xpath("//*[@class='page-title title-buttons']"));

        String tilePopUp =  titleComperePopUpWindow.getText();
        System.out.println(tilePopUp);


        List<WebElement> listPhone = driver.findElements(By.className("product-name"));
        for (int i = 0; i <listPhone.size() ; i++) {
           String namePhone = listPhone.get(i).getText();
            System.out.println(namePhone);
        }

    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
