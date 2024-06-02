import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.HomePage;

public class HomePageTest {
    public WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage=new LoginPage(driver);
        homePage=new HomePage(driver);


        loginPage.loginApplication("rahul","rahul@2021");
        String actualUrl="https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void checkingHeadingTexts() {

        Assert.assertTrue(homePage.getHomeMovieHeading().isDisplayed(),"Movie Heading  is not displayed");

        Assert.assertTrue(homePage.getHomeMovieDesc().isDisplayed(),"Movie Description is not displayed");

        Assert.assertTrue(homePage.getHomeMovieHeadingTrending().isDisplayed(),"Trending Now  is not displayed");

        Assert.assertTrue(homePage.getHomeMovieHeadingOriginals().isDisplayed(),"Originals is not displayed");

        String actualContactSection=homePage.getContactSection();
        Assert.assertEquals(actualContactSection,"Contact Us","Contact Us section is not displayed");

        Assert.assertTrue(homePage.allMoviesDisplayed().isDisplayed(),"Movie count  is not displayed");

    }

}
