package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.util.Random;

public class TestBase {
    WebDriver driver = new ChromeDriver();
    @BeforeMethod
    public void initWebDriver(){
      //  driver = new ChromeDriver();
        driver.get("https://mish.sheygam.com/#/wellcome");
        driver.manage().window().maximize();
    }

    //@AfterSuite
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public void waitUntilElementIsLoaded(WebDriver driver,
                                          By locator, int time)
    {
        try {
            new WebDriverWait(driver, time).until(ExpectedConditions
                    .presenceOfElementLocated(locator));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String latinDigitString(int length){
        String str = "";
        char ch;
        int number;
        Random gen = new Random();
        int i = 0;
        do {
            number = '0'/*по табл. Аски это 48*/+ gen.nextInt('z' - '0' +1);//метод gen.nextInt(100)+1+20-посмотнть выбор рандомальных чисел от 20 до 120
            if ((number <= '9') || (number >= 'A' && number <= 'Z') || (number >= 'a'))
            {
                str = str + (char)number;
            }
        }while(str.length()<length);
        return str;
    }
}