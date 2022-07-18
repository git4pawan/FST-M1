package SeleniumActivities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Page title is: " + driver.getTitle());

        //Get parent window handle
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);

        //Find link to open new tab and click it
        driver.findElement(By.linkText("Click Me!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Get Window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindowHandles);

        //Loop through each handle
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        //Print the handle of the current window
        System.out.println("Current window handle: " + driver.getWindowHandle());

        //Wait for page to load completely and print new tab title
        wait.until(ExpectedConditions.titleIs("Newtab"));
        System.out.println("New Tab Title is: " + driver.getTitle());

        //Get and print heading on new page
        Thread.sleep(2000);
        String newTabText = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("New tab heading is: " + newTabText);

        //Open Another Tab
        driver.findElement(By.linkText("Open Another One!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));

        //Make sure the new tab's handle is part of the handles set
        allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindowHandles);

        //Loop through the handles set till we get to the newest handle
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        //Print the handle of the current window
        System.out.println("New tab handle: " + driver.getWindowHandle());

        //Wait for the newest tab to load completely and print the title of the new tab
        wait.until(ExpectedConditions.titleIs("Newtab2"));
        System.out.println("New Tab Title is: " + driver.getTitle());

        //Get and print heading on new page
        newTabText = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("New tab heading is: " + newTabText);

        driver.quit();
    }
}
