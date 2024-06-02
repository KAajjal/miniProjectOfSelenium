import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;
import pages.HeaderSectionPage;
import pages.LoginPage;

public class HeaderSectionTest {
    public WebDriver driver;
    HeaderSectionPage headerSectionPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ASUS\\\\Downloads\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);


        loginPage.loginApplication("rahul", "rahul@2021");
        String actualUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void headerSectionUi() {
        Assert.assertTrue(headerSectionPage.getHeaderWebsiteLogo().isDisplayed(), "Header Website Logo not displayed");


    }

    @Test(priority = 2)
    public void headerSectionPopularFuctionality() {

        // checking the navigation of Popular page through elements in the header section

        headerSectionPage.clickPopularNavbar();
        String actualPopularUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(actualPopularUrl));

        String currentPopularUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualPopularUrl, currentPopularUrl, "Popular URLs do not match");


    }

    @Test(priority = 3)
    public void headerSectionAccountFuctionality(){

        headerSectionPage.clickAccountHomeNavbar();

        String actualAccountUrl="https://qamoviesapp.ccbp.tech/account";

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.urlToBe(actualAccountUrl));

        String currentAccountUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualAccountUrl,currentAccountUrl,"Account URLs do not match");
    }

    @Test(priority = 4)
    public void headerSectionHomeFuctionality(){
        headerSectionPage.clickHomeNavbar();

        String actualHomeUrl="https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.urlToBe(actualHomeUrl));

        String currentHomeUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualHomeUrl,currentHomeUrl,"Home URLs do not match");
    }
}
