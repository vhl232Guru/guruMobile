package guruMobile;

import guruMobile.pages.PageMain_GuruMobile;
import guruMobile.pages.PageMobile_2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;


public class Verify_itemIn_MobilPage_canBeSorted_1 {
        private WebDriver driver;

        @BeforeClass
        public void setPropertys(){
                System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
                driver = new ChromeDriver();
                //driver.get(UtilsClass.urlGuru);
        }

        @Test
        public void checkSortOrderOnMobile(){
             PageMain_GuruMobile pageMainGuruMobile = new PageMain_GuruMobile(driver).init();
             Assert.assertTrue(UtilsClass.titleHomePage.equalsIgnoreCase(driver.getTitle()));
             Assert.assertTrue(pageMainGuruMobile.getHtml().getText().contains(UtilsClass.mainPageTitle));
             Assert.assertTrue(pageMainGuruMobile.getMainTitle().getText().trim().equalsIgnoreCase(UtilsClass.mainPageTitle));

             pageMainGuruMobile.getMobileButton().click();

             PageMobile_2 pageMobile_2 = new PageMobile_2(driver);
             Assert.assertTrue(UtilsClass.mobilePageTitle.equalsIgnoreCase(driver.getTitle()));

             Select select = new Select(pageMobile_2.getSortMenu());
             select.selectByVisibleText("Name");

             List<String> names = pageMobile_2.getProductsList().stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());

            System.out.println(names);
            Assert.assertTrue(sortListName(names), "список не отсортирован");




            //Assert.assertTrue(pageMobile_2.isSuitable());
        }

        @AfterClass
        public void close(){
                driver.quit();
        }


        public boolean sortListName(List<String>name){
            for (int i = 0; i <name.size()-1 ; i++) {
                int r = name.get(i).compareTo(name.get(i + 1));
                if(r>0)
                    return false;
            }
            return true;
        }





}
