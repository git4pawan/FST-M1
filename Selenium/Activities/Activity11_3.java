package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_3 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");

        System.out.println("Page title is: " + driver.getTitle());

        //Click the button to open a prompt
        driver.findElement(By.cssSelector("button#prompt")).click();

        //Switch to prompt window and display the text in the prompt box
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Alert text is: " + alertText);

        //Type "Awesome!" into the prompt and Close it
        promptAlert.sendKeys("Awesome!");
        promptAlert.accept();

        driver.close();
    }
}
