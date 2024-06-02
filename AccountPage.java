package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage {
    By accountHeading=By.className("account-heading");
    By membershipHeading=By.cssSelector("div[class ='membership-container'] >:first-child");
    By membershipusername=By.className("membership-username");
    By membershippassword=By.className("membership-password");
    By planHeading=By.xpath("//p[text() = 'Plan details']");
    By planParagraph=By.cssSelector("div[class = 'plan-details-container'] >:first-child");
    By planDetails=By.cssSelector("div[class = 'plan-details-container'] >:nth-child(2)");
    By logoutButton=By.xpath("//button[text() = 'Logout']");

    WebDriver driver;
    WebDriverWait wait;

    public AccountPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    }


    public String getAccountHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountHeading));
        return driver.findElement(accountHeading).getText();
    }

    public String getMembershipHeading(){
        return driver.findElement(membershipHeading).getText();
    }

    public String getMembershipUsername(){
        return driver.findElement(membershipusername).getText();
    }

    public String getMembershipPassword(){
        return driver.findElement(membershippassword).getText();
    }


    public String getPlanHeading(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(planHeading));
        return driver.findElement(planHeading).getText();
    }

    public String getPlanParagraph(){
        return driver.findElement(planParagraph).getText();
    }

    public String getPlanDetails(){
        return driver.findElement(planDetails).getText();
    }

    public void clickLogoutButton(){
        driver.findElement(logoutButton).click();
    }

}
