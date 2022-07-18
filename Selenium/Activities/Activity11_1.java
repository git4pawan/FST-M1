package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        //Click the simple alert button
        driver.findElement(By.cssSelector("button#simple")).click();

        //Switch to alert window and display the text present in Alert
        Alert simpleAlert = driver.switchTo().alert();
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Close the alert box
        simpleAlert.accept();

        driver.close();
    }
}