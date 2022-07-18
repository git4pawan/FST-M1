package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        //Click the simple alert button
        driver.findElement(By.cssSelector("button#confirm")).click();

        //Switch to alert window and display the text present in Alert
        Alert confirmAlert = driver.switchTo().alert();
        String alertText = confirmAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Close the alert with OK
        //confirmAlert.accept();

        //Close the alert with Cancel
        confirmAlert.dismiss();

        driver.close();
    }
}
