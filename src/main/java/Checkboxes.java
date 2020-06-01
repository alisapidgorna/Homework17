import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.*;
import java.util.List;

public class Checkboxes {
    public static String browser = "chrome";
    public static WebDriver driver = null;

    public static void main(String[] args) {
        if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        //Open site makeup.com.ua
        driver.get("https://makeup.com.ua/");
        driver.manage().window().maximize();

        //Click on Hair button
        driver.findElement(By.xpath("//*[@class='menu-list__link' and @href='/categorys/20272/']")).click();

        //Choose Group of products checkbox
        WebElement groupOfCheckboxes = driver.findElement(By.xpath("//*[@id=\"filter-block-wrap\"]/div[2]/div/div/ul"));

        //Put marks on all products in Group of products checkbox and show all products from this checkbox
        List<WebElement> checkboxes = groupOfCheckboxes.findElements(By.xpath("//*[contains(@id,\"input-checkbox-2251\")]"));
        System.out.println("Products in Group of products checkbox: ");
        for (WebElement checkbox: checkboxes){
            checkbox.click();
            System.out.println(checkbox.getText());
        }
    }
}