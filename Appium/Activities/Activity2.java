package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void setup() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "PixelEm");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void testSearchAppium() throws InterruptedException {
        driver.get("https://www.training-support.net/");

        // Wait for page to load
        //wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("About Us")));

        // Print page header
        Thread.sleep(3000);
        String pageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
        System.out.println("Title on Homepage: " + pageTitle);

        // Find About Us button and click
        driver.findElementByXPath("//android.view.View[@text='About Us']").click();

        // Wait for new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[@text='About Us']")));

        // Get heading on About Us page and print it
        String newPageTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
        System.out.println("Title on new page: " + newPageTitle);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
