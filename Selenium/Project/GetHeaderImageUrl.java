package seleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetHeaderImageUrl {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		
		String imgurl = driver.findElement(By.xpath("//img[contains(@class,'attachment-large')]")).getAttribute("src");
		System.out.println("Image URL is: " + imgurl);				
		driver.close();

	}

}
