package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MoviesPage {

    // Home page Movie Elements
    By clickmovieTitanic=By.cssSelector("img[src *= 'titanic']");
    By movieTittle=By.className("movie-title");
    By movieHeading=By.xpath("//h1[text() = 'Titanic']");

    By movieReviewTime=By.cssSelector("div[class = 'movie-review-container'] >:nth-child(1)");
    By movieReviewRatings=By.cssSelector("div[class = 'movie-review-container'] >:nth-child(2)");
    By movieReviewYear=By.cssSelector("div[class = 'movie-review-container'] >:nth-child(3)");

    By movieOverview=By.className("movie-overview");

    By genreHeading=By.cssSelector("div.genres-category >:first-child");
    By genreCategory=By.cssSelector("div.genres-category >div >:first-child");

    By audioHeading=By.cssSelector("div.audio-category >:first-child");
    By audioCategory=By.cssSelector("div.audio-category >ul li p");

    By ratingHeading=By.cssSelector("div[class = 'rating-category'] >:nth-child(1)");
    By ratingCategory=By.cssSelector("div[class = 'rating-category'] >:nth-child(2)");
    By ratingAverageHeading=By.cssSelector("div[class = 'rating-category'] >:nth-child(3)");
    By ratingCountCategory=By.xpath("//p[text() = '7.6']");

    By budgetHeading=By.cssSelector("div[class = 'budget-category'] >:nth-child(1)");
    By budgetCategory=By.cssSelector("div[class = 'budget-category'] >:nth-child(2)");
    By budgetReleaseHeading=By.cssSelector("div[class = 'budget-category'] >:nth-child(3)");
    By budgetReleaseCategory=By.xpath("//p[text() = '25th March 1981']");

    By similarHeading=By.cssSelector("div[class = 'similar-movies-container'] >:first-child");
    By similarMOviesList=By.cssSelector("ul[class = 'similar-movies-list-container'] li");


    WebDriver driver;
    WebDriverWait wait;
    // home page movie Methods
    public MoviesPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void clickOnMOvieTitanic(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(clickmovieTitanic));
        driver.findElement(clickmovieTitanic).click();
    }

    public WebElement getMoviesTittle()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTittle));
        return driver.findElement(movieTittle);
    }

    public String getMovieHeading(){
        return driver.findElement(movieHeading).getText();
    }

    public String getMoviesReviewTime()  {
        return driver.findElement(movieReviewTime).getText();
    }

    public String getMoviesReviewRatings()  {
        return driver.findElement(movieReviewRatings).getText();
    }

    public String getMoviesReviewYear()  {
        return driver.findElement(movieReviewYear).getText();
    }

    public WebElement getMoviesOverview()  {
        return driver.findElement(movieOverview);
    }

    public String getGenreHeading()  {
        return driver.findElement(genreHeading).getText();
    }

    public String getGenreCategory()  {
        return driver.findElement(genreCategory).getText();
    }

    public String getAudioHeading()  {
        return driver.findElement(audioHeading).getText();
    }

    public String getAudioCategory()  {
        return driver.findElement(audioCategory).getText();
    }

    public String getRatingHeading()  {
        return driver.findElement(ratingHeading).getText();
    }

    public String getRatingCategory()  {
        return driver.findElement(ratingCategory).getText();
    }

    public String getRatingAverageHeading()  {
        return driver.findElement(ratingAverageHeading).getText();
    }

    public String getRatingCountCategory()  {
        return driver.findElement(ratingCountCategory).getText();
    }

    public String getBudgetHeading()  {
        return driver.findElement(budgetHeading).getText();
    }

    public String getBudgetCategory()  {
        return driver.findElement(budgetCategory).getText();
    }

    public String getBudgetReleaseHeading()  {
        return driver.findElement(budgetReleaseHeading).getText();
    }

    public String getBudgetReleaseCategory()  {
        return driver.findElement(budgetReleaseCategory).getText();
    }

    public String getSimilarHeading()  {

        wait.until(ExpectedConditions.visibilityOfElementLocated(similarHeading));
        return driver.findElement(similarHeading).getText();
    }

    public int getSimilarMovieList() {
        List<WebElement> list = driver.findElements(similarMOviesList);
        return list.size();
    }




}

