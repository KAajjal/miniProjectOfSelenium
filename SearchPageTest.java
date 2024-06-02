import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.*;

public class SearchPageTest {
    public WebDriver driver;
    SearchPage searchPage;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ASUS\\\\Downloads\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);
        searchPage=new SearchPage(driver);


        loginPage.loginApplication("rahul", "rahul@2021");
        String actualUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));

        headerSectionPage.clickPopularNavbar();
        String actualPopularUrl = "https://qamoviesapp.ccbp.tech/popular";

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.urlToBe(actualPopularUrl));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(priority = 1)
    public void checkEmptySearchIcon(){
        headerSectionPage.clickPopularNavbar();

        searchPage.clickOnSearchEmptyIcon();

        String actualSearchUrl="https://qamoviesapp.ccbp.tech/search";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualSearchUrl));

        String currentSearchUrl=driver.getCurrentUrl();

        Assert.assertEquals(actualSearchUrl,currentSearchUrl,"URLs do not match");

        searchPage.searchApplication("a");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        int actualCount = searchPage.getMoviesCount();
        System.out.println(actualCount);    // this line will print the count of movies

    }
}
