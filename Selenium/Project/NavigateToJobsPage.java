package seleniumProject;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class NavigateToJobsPage {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://alchemy.hguy.co/jobs/");
		
		driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
		wait.until(ExpectedConditions.titleContains("Jobs"));
		
		String expecTitle = "Jobs – Alchemy Jobs";
		String pageTitle = driver.getTitle();
		System.out.println("Navigated Page Title is: " + pageTitle);
		assertEquals(pageTitle, expecTitle, "Title not Matched");
		Reporter.log("Title Matched", true);
		
		driver.close();
	}

}
