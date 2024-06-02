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

public class MoviePopularDetailPageTest {
    public WebDriver driver;
    MoviePopularDetailPage moviePopularDetailPage;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ASUS\\\\Downloads\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);
        moviePopularDetailPage=new MoviePopularDetailPage(driver);

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
    public void getPopularMovieFunctionality(){


        moviePopularDetailPage.clickOnNarniaMOvieTitanic();

        String movieNarniaUrl="https://qamoviesapp.ccbp.tech/movies/8c288a68-9e27-422a-99a8-022a33ed0517";

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(movieNarniaUrl));

        String currentUrl=driver.getCurrentUrl();

        Assert.assertEquals(movieNarniaUrl,currentUrl,"URLs do not match");

        Assert.assertTrue(moviePopularDetailPage.getNarniaMoviesTittle().isDisplayed(),"Narnia Movie Tittle is not displayed");

        // Movie Main Heading test functionality
        String actualMovieHeading=moviePopularDetailPage.getNarniaMovieHeading();
        Assert.assertEquals(actualMovieHeading,"Narnia","Narnia Movie Heading is not displayed");

        // Movie Overview test functionality
        Assert.assertTrue(moviePopularDetailPage.getNarniaMoviesOverview().isDisplayed(),"Narnia overview not displayed");

        // Review test functionality
        String actualReviwTime=moviePopularDetailPage.getNarniaMoviesReviewTime();
        Assert.assertEquals(actualReviwTime,"2h 19m","Narnia Review Time is not matched");

        String actualReviwRating=moviePopularDetailPage.getNarniaMoviesReviewRatings();
        Assert.assertEquals(actualReviwRating,"U/A","Narnia Review Ratings is not matched");

        String actualReviwYear=moviePopularDetailPage.getNarniaMoviesReviewYear();
        Assert.assertEquals(actualReviwYear,"2021","Narnia Review Year is not matched");

        // Genre test functionality
        String actualGenreHeading=moviePopularDetailPage.getNarniaGenreHeading();
        Assert.assertEquals(actualGenreHeading,"Genres","Narnia Genre Heading is not  matched");

        String actualGenreCategory=moviePopularDetailPage.getNarniaGenreCategory();
        Assert.assertEquals(actualGenreCategory,"Western","Narnia Genre Category is not  matched");

        // Audio  test functionality
        String actualAudioHeading=moviePopularDetailPage.getNarniaAudioHeading();
        Assert.assertEquals(actualAudioHeading,"Audio Available","Narnia Audio Heading is not  matched");

        String actualAudioCategory=moviePopularDetailPage.getNarniaAudioCategory();
        Assert.assertEquals(actualAudioCategory,"English","Narnia Audio Category is not  matched");

        // rating test functionality

        String actualRatingHeading=moviePopularDetailPage.getNarniaRatingHeading();
        Assert.assertEquals(actualRatingHeading,"Rating Count","Narnia Rating Heading is not  matched");

        String actualRatingCategory=moviePopularDetailPage.getNarniaRatingCategory();
        Assert.assertEquals(actualRatingCategory,"270","Narnia Rating Category is not  matched");

        String actualRatingAverageHeading=moviePopularDetailPage.getNarniaRatingAverageHeading();
        Assert.assertEquals(actualRatingAverageHeading,"Rating Average","Narnia Rating Average Heading is not  matched");

        String actualRatingCount=moviePopularDetailPage.getNarniaRatingCountCategory();
        Assert.assertEquals(actualRatingCount,"6.6","Narnia Rating Count is not  matched");

        // rating test functionality

        String actualBudgetHeading=moviePopularDetailPage.getNarniaBudgetHeading();
        Assert.assertEquals(actualBudgetHeading,"Budget","Narnia Budget Heading is not  matched");

        String actualBudgetCategory=moviePopularDetailPage.getNarniaBudgetCategory();
        Assert.assertEquals(actualBudgetCategory,"10 Crores","Narnia Budget Category is not  matched");

        String actualBudgetReleaseHeading=moviePopularDetailPage.getNarniaBudgetReleaseHeading();
        Assert.assertEquals(actualBudgetReleaseHeading,"Release Date","Narnia Budget Release Heading is not  matched");

        String actualBudgetReleaseCategory=moviePopularDetailPage.getNarniaBudgetReleaseCategory();
        Assert.assertEquals(actualBudgetReleaseCategory,"22nd October 2021","Narnia Budget Release Category is not  matched");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("similar-movies-container")));
        Assert.assertEquals(moviePopularDetailPage.getNarniaSimilarHeading(),"More like this","More like this heading is not visible");


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("similar-movies-container")));
        int actualCount = moviePopularDetailPage.getNarniaSimilarMovieList();
        System.out.println(actualCount);

    }

}
