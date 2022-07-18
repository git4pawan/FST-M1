package SeleniumActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/popups");

        //Find the Sign in button and Hover over button and print the tooltip
        WebElement button = driver.findElement(By.xpath("//button[contains(@class, 'orange')]"));
        builder.moveToElement(button).pause(Duration.ofSeconds(1)).build().perform();
        String tooltipText = button.getAttribute("data-tooltip");
        System.out.println("Tooltip text: " + tooltipText);
        
        //Click on the button and wait for the modal to appear
        button.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInModal")));
        
        //Fill in the input fields and click on the button
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        
        //Print the login message and close
        String message = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println(message);
        
        driver.close();
    }
}