package seleniumProject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class VerifySecondHeader {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		
		String actualHeader = driver.findElement(By.xpath("//h2")).getText();
		System.out.println("Second Header is: " + actualHeader);
		
		String expecHeader = "Quia quis non";
		
		assertEquals(actualHeader, expecHeader, "Second Header isn't matching");
		
		Reporter.log("Second Header matches", true);
		driver.close();

	}

}
