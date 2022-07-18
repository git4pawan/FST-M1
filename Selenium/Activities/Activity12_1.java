package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/iframes");

        System.out.println("Title of the page is: " + driver.getTitle());
        
        //Switch to first iFrame and Perform operation on the first frame
        driver.switchTo().frame(0);
        WebElement frameHeading1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading1.getText());

        //Click button in iFrame 1 and print New button info
        WebElement button1 = driver.findElement(By.cssSelector("button"));
        button1.click();
        System.out.println(button1.getText());
        System.out.println(button1.getCssValue("background-color"));
        
        //Switch back to parent page
        driver.switchTo().defaultContent();

        //Switch to second iFrame on the page and Perform operation on the second frame
        driver.switchTo().frame(1);
        WebElement frameHeading2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frameHeading2.getText());

        //Click button in iFrame 2 and Print New Button Info
        WebElement button2 = driver.findElement(By.cssSelector("button"));
        button2.click();
        System.out.println(button2.getText());
        System.out.println(button2.getCssValue("background-color"));

        //Switch back to parent page
        driver.switchTo().defaultContent();

        driver.close();
    }
}
