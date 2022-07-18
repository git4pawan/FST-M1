package SeleniumActivities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net");
        Thread.sleep(2000);
        //Get the title of the page and display
        String title = driver.getTitle();
        System.out.println("Title of the page is: " + title);
        
        //Find the About Us link using different locators
        String classNameLocatorText = driver.findElement(By.className("green")).getText();
        System.out.println(classNameLocatorText);
        
        System.out.println("Text in Element: " + driver.findElement(By.id("about-link")).getText());   
        
        WebElement linkTextLocator = driver.findElement(By.linkText("About Us"));
        System.out.println("Text in Element: " + linkTextLocator.getText());
        
        String cssLocatorText = driver.findElement(By.cssSelector("a#about-link")).getText();
        System.out.println("Text in Element: " + cssLocatorText);
        driver.close();

	}

}
