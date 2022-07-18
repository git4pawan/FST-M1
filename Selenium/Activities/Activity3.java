package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.training-support.net/selenium/simple-form");
        Thread.sleep(2000);
        
        //Get the title of the page and display
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        
        //Find the fields
        WebElement firstName = driver.findElement(By.id("firstName"));
        WebElement lastName = driver.findElement(By.id("lastName"));
        //Enter text
        firstName.sendKeys("Pawan");
        lastName.sendKeys("Gupta");
        
        //Enter the email and contact number
        driver.findElement(By.id("email")).sendKeys("test@example.com");
        driver.findElement(By.id("number")).sendKeys("1234567890");
        
        //Click Submit
        driver.findElement(By.cssSelector("input.ui.green.button")).click();
        driver.close();

	}

}
