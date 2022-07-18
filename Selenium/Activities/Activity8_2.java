package SeleniumActivities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");

        //Print no. of columns
        List<WebElement> cols = driver.findElements(By.xpath("//table[@id='sortableTable']/thead/tr/th"));
        System.out.println("Number of columns are: " + cols.size());
        //Print no. of rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.println("Number of rows are: " + rows.size());

        //Print Cell value of second row, second column
        WebElement cellValueBefore = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("2nd row, 2nd column value(Before sorting): " + cellValueBefore.getText());

        //Sort the table
        driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[2]")).click();

        //Print Cell value of second row, second column
        WebElement cellValueAfter = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("2nd row, 2nd column value(After sorting): " + cellValueAfter.getText());

        //Print footer cell value
        WebElement footer = driver.findElement(By.xpath("//table[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + footer.getText());

        driver.close();
    }
}
