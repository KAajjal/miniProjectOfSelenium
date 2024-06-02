package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HeaderSectionPage {
    By headerWebsiteLogo=By.cssSelector("div[class $=nav-content] img.website-logo");
    By headerNavHomeLOcator=By.linkText("Home");
    By headerNavPopularLOcator=By.linkText("Popular");
    By headerNavAccountLOcator=By.cssSelector("div[class $=nav-content] + div>:nth-child(2)");

    WebDriver driver;
    WebDriverWait wait;

    public HeaderSectionPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public WebElement getHeaderWebsiteLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerWebsiteLogo));
        return driver.findElement(headerWebsiteLogo);
    }

    public void clickHomeNavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavHomeLOcator));
         driver.findElement(headerNavHomeLOcator).click();
    }

    public void clickPopularNavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavPopularLOcator));
        driver.findElement(headerNavPopularLOcator).click();
    }


    public void clickAccountHomeNavbar(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerNavAccountLOcator));
        driver.findElement(headerNavAccountLOcator).click();
    }



}
