package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchPage {
    By searchEmptyIcon=By.cssSelector("div.search-account-container >:first-child");
    By searchInputField=By.cssSelector("input#search");
    By searchIconButton=By.className("search-button");
    By moviesCount=By.cssSelector("ul.search-movies-container li");

    WebDriver driver;
    public SearchPage(WebDriver driver){
        this.driver=driver;
    }

    public void clickOnSearchEmptyIcon(){
        driver.findElement(searchEmptyIcon).click();
    }

    public void enterSearchInputField(String movieName){
        driver.findElement(searchInputField).sendKeys(movieName);
    }

    public void clickOnSearchIcon(){
        driver.findElement(searchIconButton).click();
    }

    public void searchApplication(String moviesName){
        enterSearchInputField(moviesName);
        clickOnSearchIcon();
    }

    public int getMoviesCount() {
        List<WebElement> list = driver.findElements(moviesCount);
        return list.size();
    }



}

