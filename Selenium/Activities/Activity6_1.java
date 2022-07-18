package SeleniumActivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Find checkbox and toggle button
        WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        WebElement toggleCheckboxButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
       
        toggleCheckboxButton.click();
        
        //Wait for checkbox to disappear and click the toggle again
        wait.until(ExpectedConditions.invisibilityOf(checkbox));
        toggleCheckboxButton.click();
        
        //Wait for checkbox to appear and click it
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();
      
        driver.close();
    }

}
