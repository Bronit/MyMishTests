package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AccountCreatePageTestsWithoutRandomEm extends TestBase {
    @Test
    public void NewAccountCreatePositive() throws InterruptedException {
        waitUntilElementIsLoaded(driver,
                By.xpath("//span[contains(text(),'Login')]"),
                45);
        WebElement createAccount = driver.findElement(By.xpath("//span[contains(text(),'Create Account')]"));
        createAccount.click();

        WebElement mailField = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        mailField.click();
        mailField.sendKeys("12qaz@qaz");

        WebElement passwordField = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
        passwordField.click();
        passwordField.sendKeys("123456");

        WebElement repPasswordField = driver.findElement(By.xpath("//input[@formcontrolname='passwordRep']"));
        repPasswordField.click();
        repPasswordField.sendKeys("123456");

        waitUntilElementIsLoaded(driver, By.xpath("//span[contains(text(),'Registration')]"), 20);
        WebElement registrationButton = driver.findElement(By.xpath("//span[contains(text(),'Registration')]"));
        registrationButton.click();

        waitUntilElementIsLoaded(driver,
                By.xpath("//h1[@class='classCentr']"),
                45);
        WebElement cancelButton = driver
                .findElement(By.xpath("//button[@type='button']//span[contains(text(),'Cancel')]/.."));
        cancelButton.click();

        waitUntilElementIsLoaded(driver,
                By.xpath("//mat-icon[@mattooltip='Menu']"), 45);
        // waitUntilElementIsLoaded(driver, By.xpath("//mat-icon[@class='but mat-icon material-icons']"),20);
        WebElement iconMenu = driver.findElement(By.xpath("//mat-icon[@class='but mat-icon material-icons']"));
        iconMenu.click();
        waitUntilElementIsLoaded(driver, By.xpath("//span[@class='marginLeft']"), 20);
        WebElement logOutMenu = driver.findElement(By.xpath("//span[@class='marginLeft']"));
        logOutMenu.click();
    }

//------------------------------Login created user----------
        @Test
        public void newAccountAndLogin() {
        waitUntilElementIsLoaded(driver, By.xpath("//span[contains(text(),'Login')]"), 40);
        WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Login')]"));
        login.click();

        waitUntilElementIsLoaded(driver, By.xpath("//button[@type='button']/span[contains(text(),'Cancel')]/.."), 20);
        WebElement emailReg = driver.findElement(By.xpath("//input[@formcontrolname='email']"));
        emailReg.click();
        emailReg.sendKeys("12qaz@qaz");

        WebElement passReg = driver.findElement(By.xpath("//input[@formcontrolname='password']"));
        passReg.click();
        passReg.sendKeys("123456");

        WebElement log_In = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
        log_In.click();

    }
}
