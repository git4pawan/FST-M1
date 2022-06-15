package seleniumProject;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyJob {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://alchemy.hguy.co/jobs/");
		
		driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
		wait.until(ExpectedConditions.titleContains("Jobs"));
		
		driver.findElement(By.id("search_keywords")).sendKeys("Banking");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset']")));
		driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='button']"))).click();
		
		String email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='job_application_email']"))).getText();
		System.out.println("Job email is: " + email);
		driver.close();

	}

}
