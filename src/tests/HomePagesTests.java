package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EventsUnAuthPageHelper;
import pages.HomePageHelper;

import java.util.List;

/**
 * Created by Inka on 16-Dec-18.
 */
public class HomePagesTests extends TestBase{
    HomePageHelper homePage;
    EventsUnAuthPageHelper eventsUnAuthPage;

    @BeforeMethod
    public void initPage(){
        homePage = PageFactory
                .initElements(driver,HomePageHelper.class);
        eventsUnAuthPage = PageFactory
                .initElements(driver,EventsUnAuthPageHelper.class);

    }
    @Test
    public void openHomePage()  {

       /* waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Login')]"),
                45);
        WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));
        Assert.assertTrue(goToEventsButton.getText()
                .equals("Go to Event list"));*/
        homePage.waitUntilPageLoad();
        String goToButtonName =
                homePage.getGoToEventButtonName();

        Assert.assertEquals("Go to Event list",goToButtonName);
    }

    @Test
    public void goToEventsTest()  {
       /* waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Login')]"),
                45);
        WebElement goToEventsButton = driver.findElement(
                By.className("mat-stroked-button"));
        goToEventsButton.click();
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Filters')]"),
                20 );
        WebElement titlePage = driver.findElement(By
                .xpath("//h1[@class='gorisontal-center']"));
        Assert.assertTrue(titlePage.getText().equals("Find event"));
        homePage.waitUntilPageLoad();*/
        homePage.pressGoToEventButton();
        eventsUnAuthPage.waitUntilPageLoad();
        String header = eventsUnAuthPage.getHeader();
        Assert.assertEquals("Find event",header);
    }

}