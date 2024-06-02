package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class MoviePopularDetailPage {

    // Popular page Movie Elements

    By clickmovieNarnia=By.cssSelector("img[src *= 'narnia']");
    By movieNarniaTittle=By.className("movie-title");
    By movieNarniaHeading=By.xpath("//h1[text() = 'Narnia']");

    By movieNarniaReviewTime=By.cssSelector("div[class = 'movie-review-container'] >:nth-child(1)");
    By movieNarniaReviewRatings=By.cssSelector("div[class = 'movie-review-container'] >:nth-child(2)");
    By movieNarniaReviewYear=By.cssSelector("div[class = 'movie-review-container'] >:nth-child(3)");

    By movieNarniaOverview=By.cssSelector("div.title-details-container p.movie-overview");

    By genreNarniaHeading=By.cssSelector("div.genres-category >:first-child");
    By genreNarniaCategory=By.cssSelector("div.genres-category >div >:first-child");

    By audioNarniaHeading=By.cssSelector("div.audio-category >:first-child");
    By audioNarniaCategory=By.cssSelector("div.audio-category >ul li p");

    By ratingNarniaHeading=By.cssSelector("div[class = 'rating-category'] >:nth-child(1)");
    By ratingNarniaCategory=By.cssSelector("div[class = 'rating-category'] >:nth-child(2)");
    By ratingNarniaAverageHeading=By.cssSelector("div[class = 'rating-category'] >:nth-child(3)");
    By ratingNarniaCountCategory=By.xpath("//p[text() = '6.6']");

    By budgetNarniaHeading=By.cssSelector("div[class = 'budget-category'] >:nth-child(1)");
    By budgetNarniaCategory=By.cssSelector("div[class = 'budget-category'] >:nth-child(2)");
    By budgetNarniaReleaseHeading=By.cssSelector("div[class = 'budget-category'] >:nth-child(3)");
    By budgetNarniaReleaseCategory=By.xpath("//p[text() = '22nd October 2021']");

    By similarNarniaHeading=By.cssSelector("div[class = 'similar-movies-container'] >:first-child");
    By similarNarniaMOviesList=By.cssSelector("ul[class = 'similar-movies-list-container'] li");


    WebDriver driver;
    WebDriverWait wait;
    public MoviePopularDetailPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    // Popular page movie Methods

    public void clickOnNarniaMOvieTitanic(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
        driver.findElement(clickmovieNarnia).click();
    }

    public WebElement getNarniaMoviesTittle()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieNarniaTittle));
        return driver.findElement(movieNarniaTittle);
    }

    public String getNarniaMovieHeading(){
        return driver.findElement(movieNarniaHeading).getText();
    }

    public String getNarniaMoviesReviewTime()  {
        return driver.findElement(movieNarniaReviewTime).getText();
    }

    public String getNarniaMoviesReviewRatings()  {
        return driver.findElement(movieNarniaReviewRatings).getText();
    }

    public String getNarniaMoviesReviewYear()  {
        return driver.findElement(movieNarniaReviewYear).getText();
    }

    public WebElement getNarniaMoviesOverview()  {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieNarniaOverview));
        return driver.findElement(movieNarniaOverview);
    }

    public String getNarniaGenreHeading()  {
        return driver.findElement(genreNarniaHeading).getText();
    }

    public String getNarniaGenreCategory()  {
        return driver.findElement(genreNarniaCategory).getText();
    }

    public String getNarniaAudioHeading()  {
        return driver.findElement(audioNarniaHeading).getText();
    }

    public String getNarniaAudioCategory()  {
        return driver.findElement(audioNarniaCategory).getText();
    }

    public String getNarniaRatingHeading()  {
        return driver.findElement(ratingNarniaHeading).getText();
    }

    public String getNarniaRatingCategory()  {
        return driver.findElement(ratingNarniaCategory).getText();
    }

    public String getNarniaRatingAverageHeading()  {
        return driver.findElement(ratingNarniaAverageHeading).getText();
    }

    public String getNarniaRatingCountCategory()  {
        return driver.findElement(ratingNarniaCountCategory).getText();
    }

    public String getNarniaBudgetHeading()  {
        return driver.findElement(budgetNarniaHeading).getText();
    }

    public String getNarniaBudgetCategory()  {
        return driver.findElement(budgetNarniaCategory).getText();
    }

    public String getNarniaBudgetReleaseHeading()  {
        return driver.findElement(budgetNarniaReleaseHeading).getText();
    }

    public String getNarniaBudgetReleaseCategory()  {
        return driver.findElement(budgetNarniaReleaseCategory).getText();
    }

    public String getNarniaSimilarHeading()  {

        return driver.findElement(similarNarniaHeading).getText();
    }

    public int getNarniaSimilarMovieList() {
        List<WebElement> list = driver.findElements(similarNarniaMOviesList);
        return list.size();
    }
}
