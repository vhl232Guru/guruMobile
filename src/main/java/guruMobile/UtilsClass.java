package guruMobile;

public class UtilsClass {
    static String mainPageTitle = "THIS IS DEMO SITE FOR";
    static String mobilePageTitle  = "Mobile";

    public static String locationWebDriver;

    public static String urlGuru = "http://live.guru99.com/index.php/";
    public static String urlMobilePage = "http://live.guru99.com/index.php/mobile.html";

    static String titleHomePage = "Home page";

    public static String errorMeseg = "Some of the products cannot be ordered in requested quantity.";
    public static String messageEmtyCart = "Shopping Cart is Empty";
    public static String successMessageAccountPage = "Thank you for registering with Main Website Store.";
    public static String successMessageSHAREEMAIL = "Your Wishlist has been shared.";
    public static String flatRateCost = "Fixed - $5.00";
    public static String grand_Cost = "$620.00";
    public static String numberOrder = "100007265";
    public static String orderStatus = "Pending";


    static {
        locationWebDriver = "F:selenium drivera" +
                "\\ChromeDriver\\chromedriver_win32\\chromedriver.exe";
        //locationWebDriver = "E:\\Java\\chromedriver.exe";
    }

}
