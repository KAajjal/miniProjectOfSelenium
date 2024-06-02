import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.*;

public class MoviesDetailedPageTest {
    public WebDriver driver;
    MoviesPage moviesPage;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ASUS\\\\Downloads\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);
        moviesPage=new MoviesPage(driver);

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
    public void getHomeMovieFunctionality(){

        moviesPage.clickOnMOvieTitanic();

        String movieUrl="https://qamoviesapp.ccbp.tech/movies/33119fe5-3966-4bba-b98c-10b241ffc9f8";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(movieUrl));

        String currentUrl=driver.getCurrentUrl();

        Assert.assertEquals(movieUrl,currentUrl,"URLs do not match");

        // Movie Tittle test functionality
        Assert.assertTrue(moviesPage.getMoviesTittle().isDisplayed(),"Movie Tittle is not displayed");

        // Movie Main Heading test functionality
        String actualMovieHeading=moviesPage.getMovieHeading();
        Assert.assertEquals(actualMovieHeading,"Titanic","Movie Heading is not displayed");

        // Movie Overview test functionality
        Assert.assertTrue(moviesPage.getMoviesOverview().isDisplayed(),"Movie Overview not visible");

        // Review test functionality
        String actualReviwTime=moviesPage.getMoviesReviewTime();
        Assert.assertEquals(actualReviwTime,"1h 35m","Review Time is not matched");

        String actualReviwRating=moviesPage.getMoviesReviewRatings();
        Assert.assertEquals(actualReviwRating,"U/A","Review Ratings is not matched");

        String actualReviwYear=moviesPage.getMoviesReviewYear();
        Assert.assertEquals(actualReviwYear,"1981","Review Year is not matched");

        // Genre test functionality
        String actualGenreHeading=moviesPage.getGenreHeading();
        Assert.assertEquals(actualGenreHeading,"Genres","Genre Heading is not  matched");

        String actualGenreCategory=moviesPage.getGenreCategory();
        Assert.assertEquals(actualGenreCategory,"Drama","Genre Category is not  matched");

        // Audio  test functionality
        String actualAudioHeading=moviesPage.getAudioHeading();
        Assert.assertEquals(actualAudioHeading,"Audio Available","Audio Heading is not  matched");

        String actualAudioCategory=moviesPage.getAudioCategory();
        Assert.assertEquals(actualAudioCategory,"French","Audio Category is not  matched");

        // rating test functionality

        String actualRatingHeading=moviesPage.getRatingHeading();
        Assert.assertEquals(actualRatingHeading,"Rating Count","Rating Heading is not  matched");

        String actualRatingCategory=moviesPage.getRatingCategory();
        Assert.assertEquals(actualRatingCategory,"39","Rating Category is not  matched");

        String actualRatingAverageHeading=moviesPage.getRatingAverageHeading();
        Assert.assertEquals(actualRatingAverageHeading,"Rating Average","Rating Average Heading is not  matched");

        String actualRatingCount=moviesPage.getRatingCountCategory();
       Assert.assertEquals(actualRatingCount,"7.6","Rating Count is not  matched");

        // rating test functionality

        String actualBudgetHeading=moviesPage.getBudgetHeading();
        Assert.assertEquals(actualBudgetHeading,"Budget","Budget Heading is not  matched");

        String actualBudgetCategory=moviesPage.getBudgetCategory();
        Assert.assertEquals(actualBudgetCategory,"1.6 Crores","Budget Category is not  matched");

        String actualBudgetReleaseHeading=moviesPage.getBudgetReleaseHeading();
        Assert.assertEquals(actualBudgetReleaseHeading,"Release Date","Budget Release Heading is not  matched");

       String actualBudgetReleaseCategory=moviesPage.getBudgetReleaseCategory();
       Assert.assertEquals(actualBudgetReleaseCategory,"25th March 1981","Budget Release Category is not  matched");

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("similar-movies-container")));
       Assert.assertEquals(moviesPage.getSimilarHeading(),"More like this","More like this heading is not visible");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("similar-movies-container")));
        int actualCount = moviesPage.getSimilarMovieList();
        System.out.println(actualCount);

    }



}
