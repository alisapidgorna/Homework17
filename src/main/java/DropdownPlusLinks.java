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

public class DropdownPlusLinks {
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
        //Open site dou.ua
        driver.get("https://dou.ua/");
        driver.manage().window().maximize();

        //Click on Work button
        driver.findElement(By.xpath("/html/body/div[1]/header/ul/li[6]/a")).click();

        //Choose C++ in dropdown
        WebElement dropdown = driver.findElement(By.name("category"));
        Select select = new Select(dropdown);
        select.selectByValue("C++");

        //Put mark in one checkbox
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='descr']")).click();

        //Choose QA in dropdown
        driver.findElement(By.name("category")).sendKeys("QA");

        //Show elements from All categories dropdown
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Elements in All categories dropdown are: ");
        List<WebElement> values = driver.findElements(By.tagName("option"));
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i).getAttribute("value"));
        }

        //Show amount of elements in All categories dropdown
        System.out.println("____________________________________________________________________________________________");
        System.out.println("Amount of elements in All categories dropdown are: " + values.size());
        System.out.println("____________________________________________________________________________________________");

        //click on Companies button
        driver.findElement(By.linkText("Компании")).click();

        //Show total links on Companies page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links on Companies page are: " + links.size());
        System.out.println("____________________________________________________________________________________________");

        //Show names of companies plus their links
        for (WebElement link: links){
            System.out.println(link.getText() + "__________url's _________from DOU   " + link.getAttribute("href"));
        }
        System.out.println("____________________________________________________________________________________________");

        driver.quit();
    }
}