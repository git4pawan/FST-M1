package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Find the checkbox to check and display whether it's enabled
        WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("The checkbox is selected: " + textInput.isEnabled());

        driver.findElement(By.id("toggleInput")).click();

        //Print status
        System.out.println("The checkbox is selected: " + textInput.isEnabled());

        driver.close();

    }

}
