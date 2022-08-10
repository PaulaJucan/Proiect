package Test;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddCartProduct extends BaseTest {
@Test
    public void buyProduct() {


        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("email")).sendKeys("paulici_84@yahoo.com");
        driver.findElement(By.id("passwd")).sendKeys("parola123");
        driver.findElement(By.id("SubmitLogin")).click();

        driver.findElement(By.linkText("WOMEN")).click();

        WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
        WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();


        driver.findElement(By.id("quantity_wanted")).clear();
        driver.findElement(By.id("quantity_wanted")).sendKeys("2");


        WebElement Sizedrpdwn=driver.findElement(By.xpath("//*[@id='group_1']"));
        Select oSelect=new Select(Sizedrpdwn);
        oSelect.selectByVisibleText("M");


        driver.findElement(By.id("color_11")).click();


        driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();


        driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();

        driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();


        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();

        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();


        String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();


        if(ConfirmationText.contains("complete")) {
            System.out.println("Order Completed: Test Case Passed");
        }
        else {
            System.out.println("Order Not Successfull: Test Case Failed");
        }

    }
}