package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SearchProduct {

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        String URL="http://automationpractice.com/index.php";

        driver.get(URL);
        driver.manage().window().maximize();


        Actions actions=new Actions(driver);
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
        WebElement womenTab=driver.findElement(By.linkText("WOMEN"));
        WebElement TshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
        actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();
        Thread.sleep(2000);


        String ProductName=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
        System.out.println(ProductName);
        driver.findElement(By.id("search_query_top")).sendKeys(ProductName);
        driver.findElement(By.name("submit_search")).click();


        String SearchResultProductname=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();


        if(ProductName.equalsIgnoreCase(SearchResultProductname)) {
            System.out.println("Results Matched;Test Case Passed");
        }else{
            System.out.println("Results NotMatched;Test Case Failed");
        }


        driver.close();
    }

}