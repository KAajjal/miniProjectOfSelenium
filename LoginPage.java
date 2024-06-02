package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    By websiteLogo=By.className("login-website-logo");
    By signInHeading=By.className("sign-in-heading");
    By labelText=By.className("input-label");
    By usernameLocator=By.id("usernameInput");
    By passwordLocator=By.id("passwordInput");
    By loginButtonLocator=By.className("login-button");
    By errorMessageLocator=By.className("error-message");

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }


    public WebElement getWebsiteLogo(){
        return driver.findElement(websiteLogo);
    }


    public String getSignInHeading(){
        return  driver.findElement(signInHeading).getText();
    }


    public String getLabelText(int index){
        return driver.findElements(labelText).get(index).getText();
    }


    public void enterUsername(String name){
         driver.findElement(usernameLocator).sendKeys(name);
    }


    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);
    }


    public void clickLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }


    public void loginApplication(String name, String password){
        enterUsername(name);
        enterPassword(password);
        clickLoginButton();
    }


    public String getErrorMesage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator)).getText();
    }


}
