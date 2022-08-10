package Test;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SearchProduct extends BaseTest {
    @Test
    public void searchTest(){

        Actions actions=new Actions(driver);
        WebElement womenTab=driver.findElement(By.linkText("WOMEN"));
        WebElement TshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
        actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();


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


    }

}