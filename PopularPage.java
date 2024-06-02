package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class PopularPage {
    By listOfMovies=By.cssSelector("div[class $=search-movies-container] li");

    WebDriver driver;
    WebDriverWait wait;

    public PopularPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement getAlLMoviesList(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(listOfMovies));
        return driver.findElement(listOfMovies);
    }
}
