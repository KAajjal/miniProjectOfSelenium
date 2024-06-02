import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import java.time.Duration;
import pages.*;

public class AccountPageTest {
    public WebDriver driver;
    AccountPage accountPage;
    LoginPage loginPage;
    HeaderSectionPage headerSectionPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ASUS\\\\Downloads\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://qamoviesapp.ccbp.tech");
        headerSectionPage = new HeaderSectionPage(driver);
        loginPage = new LoginPage(driver);
        accountPage=new AccountPage(driver);


        loginPage.loginApplication("rahul", "rahul@2021");
        String actualUrl = "https://qamoviesapp.ccbp.tech/";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlToBe(actualUrl));

        headerSectionPage.clickPopularNavbar();
        headerSectionPage.clickAccountHomeNavbar();

        String actualAccountUrl="https://qamoviesapp.ccbp.tech/account";

        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.urlToBe(actualAccountUrl));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void testAccountUi(){
        //headerSectionPage.clickAccountHomeNavbar();
        String actualaccountHeading=accountPage.getAccountHeading();

        Assert.assertEquals(actualaccountHeading,"Account","Account Heading do not match");
    }

    @Test(priority = 2)
    public void getMembershipDetails(){
        String actualMembershipHeading=accountPage.getMembershipHeading();

        Assert.assertEquals(actualMembershipHeading,"Member ship","Membership Heading do not match");

        String actualMembershipUsername=accountPage.getMembershipUsername();

        Assert.assertEquals(actualMembershipUsername,"User name : rahul","Membership Username do not match");

        String actualMembershipPassword=accountPage.getMembershipPassword();

        Assert.assertEquals(actualMembershipPassword,"Password : **********","Membership Password do not match");
    }

    @Test(priority = 3)
    public void getPlanDetails(){


        String actualPlanHeading=accountPage.getPlanHeading();

        Assert.assertEquals(actualPlanHeading,"Plan details","Plan Heading do not match");

        String actualPlanParagraph=accountPage.getPlanParagraph();

        Assert.assertEquals(actualPlanParagraph,"Premium","Plan Membership  do not match");

        String actualPlanDetails=accountPage.getPlanDetails();

        Assert.assertEquals(actualPlanDetails,"Ultra HD","Plan Details do not match");
    }

    @Test(priority = 4)
    public void testLogoutButton(){
        accountPage.clickLogoutButton();
    }
}
