package seleniumProject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class VerifyTitle {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		
		String actualTitle = driver.getTitle();
		System.out.println("Page Title is: " + actualTitle);
		
		String expecString = "Alchemy Jobs – Job Board Application";
		
		assertEquals(actualTitle, expecString, "Title isn't matching");
		
		Reporter.log("Title matches", true);
		driver.close();

	}

}
