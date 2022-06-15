package seleniumProject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class VerifyHeader {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		
		String actualHeader = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
		System.out.println("Header is: " + actualHeader);
		
		String expecHeader = "Welcome to Alchemy Jobs";
		
		assertEquals(actualHeader, expecHeader, "Header isn't matching");
		
		Reporter.log("Header matches", true);
		driver.close();

	}

}
