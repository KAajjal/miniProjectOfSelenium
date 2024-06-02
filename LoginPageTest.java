import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ASUS\\\\Downloads\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1)
    public void loginPageUi(){
        Assert.assertTrue(loginPage.getWebsiteLogo().isDisplayed(),"App logo is not displayed");

        Assert.assertEquals(loginPage.getLabelText(0),"USERNAME","Username label text does not match");

        Assert.assertEquals(loginPage.getLabelText(1),"PASSWORD","Password label text does not match");

        String actualSignInHeading=loginPage.getSignInHeading();
        Assert.assertEquals(actualSignInHeading,"Login","Login text does not matched");

    }

    @Test(priority = 2)
    public void submissionEmptyInputs(){
        loginPage.clickLoginButton();
        String actualErorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErorMsg,"*Username or password is invalid","Error text with empty input fields does not match");

    }

    @Test(priority = 3)
    public void loginWithEmptyUsername(){
        loginPage.loginApplication("","rahul@2021");
        String actualErrorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErrorMsg,"*Username or password is invalid","Error text with empty input field do not match");
    }

    @Test(priority = 4)
    public void loginWithEmptyPassword(){
        loginPage.loginApplication("rahul","");
        String actualErrorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErrorMsg,"*Username or password is invalid","Error text with empty input field do not match");
    }

    @Test(priority = 5)
    public void loginWithInvalidCred(){
        loginPage.loginApplication("rahul","rahul");
        String actualErrorMsg=loginPage.getErrorMesage();
        Assert.assertEquals(actualErrorMsg,"*username and password didn't match","Error text with invalid password do not match");
    }

    @Test(priority = 6)
    public void loginWithValidCred(){

        loginPage.loginApplication("rahul","rahul@2021");
        String actulUrl="https://qamoviesapp.ccbp.tech/";

         WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
         wait.until(ExpectedConditions.urlToBe(actulUrl));

         String currentUrl=driver.getCurrentUrl();
         Assert.assertEquals(actulUrl,currentUrl,"URLs do not match");

    }





}
