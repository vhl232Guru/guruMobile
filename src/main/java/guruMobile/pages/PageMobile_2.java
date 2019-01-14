package guruMobile.pages;

import guruMobile.UtilsClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PageMobile_2 implements Pageable<PageMobile_2> {
    private WebDriver driver;

    public WebElement getTitleMobilePage() {
        return titleMobilePage;
    }

    @FindBy(xpath = "//*[@class='page-title category-title']")
    private WebElement titleMobilePage;

    @FindBy(tagName = "html")
    private WebElement html;

    @FindBy(xpath = "//*[@title='Sort By']")
    private WebElement sortMenu;
    @FindBy(xpath = "//ul[@class='products-grid']")
    private WebElement productGrid;
    @FindBy(id = "product-price-1")
    private WebElement cost;
    @FindBy(id = "product-collection-image-1")
    private WebElement soniXperia;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")
    private WebElement addToCartSoniXperia;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")
    private WebElement compareSonyXperia;

    @FindBy(xpath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")
    private WebElement compareIPHONE;

    @FindBy(xpath = "//*[@title='Compare']")
    private WebElement compareButton;

    public WebElement getCompareButton() {
        return compareButton;
    }

    public WebElement getCompareIPHONE() {
        return compareIPHONE;
    }

    public WebElement getCompareSonyXperia() {
        return compareSonyXperia;
    }

    public WebElement getAddToCartSoniXperia() {
        return addToCartSoniXperia;
    }

    public WebElement getSoniXperia() {
        return soniXperia;
    }

    public WebElement getCost() {
        return cost;
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }

    @FindBy(className = "product-name")
    private List<WebElement> productsList;

    public WebElement getProductGrid() {
        return productGrid;
    }

    public WebElement getSortMenu() {
        return sortMenu;
    }

    public WebElement getHtml() {
        return html;
    }

    public PageMobile_2(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public PageMobile_2 init() {
        driver.get(UtilsClass.urlMobilePage);

        return this;
    }

    public boolean isSuitable() {
        return driver.getCurrentUrl().equals(UtilsClass.urlMobilePage);
    }



}
