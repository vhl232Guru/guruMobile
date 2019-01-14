package guruMobile.email_10;

import guruMobile.UtilsClass;
import guruMobile.emailUtil.EmailUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Email {
    WebDriver driver;
    static MadgentoAdminPanelPage madgentoAdminPanelPage;
    static LoginPage loginPage;
    static String id = "user01";
    static String pass = "guru99com";
    @BeforeClass
    public void setPropery() throws InterruptedException, AWTException {
        System.setProperty("webdriver.chrome.driver", UtilsClass.locationWebDriver);
        driver = new ChromeDriver();
        driver.get("http://live.guru99.com/index.php/backendlogin");

        loginPage = new LoginPage(driver);
        loginPage.getUserNameField().sendKeys(id);
        loginPage.loginField.sendKeys(pass);
        loginPage.getLoginButton().click();
        closePopUp();

    }

    @Test
    public void email() throws IOException, InterruptedException {

       madgentoAdminPanelPage = new MadgentoAdminPanelPage(driver);

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);

        WebElement sales = wait.until(ExpectedConditions.visibilityOf(madgentoAdminPanelPage.getSalesButton()));

        Action action = actions.moveToElement(sales)
                        .click(madgentoAdminPanelPage.getOrdersButton()).build();
        action.perform();

        Select select = new Select(madgentoAdminPanelPage.getSelectCSV());
        select.selectByVisibleText("CSV");

        madgentoAdminPanelPage.getExportButton().click();

        String propPath = "C:\\Users\\Pavel\\IdeaProjects\\vhl232GuruMobile\\src\\main\\resources\\data.properties";
        InputStream inputStream = new FileInputStream(new File(propPath));
        Properties prop = new Properties();
        prop.load(inputStream);

        //must be set email and password
        String emailAdress = prop.getProperty("emailForPost");
        String pass = prop.getProperty("passwordForPost");


        EmailUtil emailUtils = new EmailUtil(emailAdress,pass);

        emailUtils.send("This is Subject", "Hallo world!",emailAdress,"" +
                "seriislon@gmail.com");
        Thread.sleep(5000);
    }

    @AfterClass
    public void close(){
        driver.quit();
    }

    public void closePopUp() throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(701,426);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}
