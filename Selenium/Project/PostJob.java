package seleniumProject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class PostJob {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://alchemy.hguy.co/jobs/");
		
		//click on post a job button
		driver.findElement(By.xpath("//li[@id='menu-item-26']/a")).click();
		wait.until(ExpectedConditions.titleContains("Post a Job"));
		
		//fill in all the details
		driver.findElement(By.id("create_account_email")).sendKeys("somey@abc.com");
		driver.findElement(By.id("job_title")).sendKeys("AutomatePR Engineer");
		driver.switchTo().frame("job_description_ifr");
		driver.findElement(By.id("tinymce")).sendKeys("Some Description");
		driver.switchTo().defaultContent();
		driver.findElement(By.id("application")).sendKeys("somey@abc.com");
		driver.findElement(By.id("company_name")).sendKeys("SAP");
		
		//click on the preview button
		driver.findElement(By.xpath("//input[@type='submit' and @class='button']")).click();
		//click on the submit listing button
		wait.until(ExpectedConditions.elementToBeClickable(By.id("job_preview_submit_button"))).click();
		
		//click on job and search the posted job
		driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
		wait.until(ExpectedConditions.titleContains("Jobs"));
		driver.findElement(By.id("search_keywords")).sendKeys("AutomatePR Engineer");
		driver.findElement(By.id("search_keywords")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Reset']")));
		
		assertTrue(driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a")).isDisplayed());
		String jobTitle = driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a/div/h3")).getText();
		assertEquals(jobTitle, "AutomatePP Engineer");
		Reporter.log("Test Successful", true);
		driver.close();

	}

}
