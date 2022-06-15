package seleniumProject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BackendJobListing {

	public static void main(String[] args) throws InterruptedException {
		//initialization and navigate to portal
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		String expJobName = "AutomateB Engineer";
		driver.get("https://alchemy.hguy.co/jobs/wp-admin");
		
		//login to the portal
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		//verify and display title after successful login
		wait.until(ExpectedConditions.titleContains("Dashboard"));
		System.out.println("Page Title is: " + driver.getTitle());
		//click on job listing button
		driver.findElement(By.xpath("//*[@id='menu-posts-job_listing']/a")).click();
		//click on Add new button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='page-title-action']"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("post-title-0"))).sendKeys(expJobName);
		driver.findElement(By.xpath("//button[contains(@class,'is-primary')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Publish']")).click();
		String jobName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'post-publish-panel__postpublish-header')]/a"))).getText();
		assertEquals(jobName, expJobName, "Job not created successfully");
		Reporter.log(jobName, true);
		driver.close();
	}

}
