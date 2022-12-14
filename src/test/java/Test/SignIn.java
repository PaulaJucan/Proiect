package Test;

import Base.BaseTest;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SignIn extends BaseTest {
    @Test
    public void registration(){

        driver.findElement(By.linkText("Sign in")).click();


        driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("bobonet@gmail.com");

        driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();


        driver.findElement(By.xpath("//input[@id=\"id_gender2\"]")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("paula");
        driver.findElement(By.name("customer_lastname")).sendKeys("jucan");
        driver.findElement(By.id("passwd")).sendKeys("parola123");


        driver.findElement(By.id("firstname")).sendKeys("paula");
        driver.findElement(By.id("lastname")).sendKeys("jucan");
        driver.findElement(By.id("company")).sendKeys("Azimut");
        driver.findElement(By.id("address1")).sendKeys("eroilor");
        driver.findElement(By.id("city")).sendKeys("Cluj");
        WebElement statedropdown=driver.findElement(By.name("id_state"));
        Select oSelect=new Select(statedropdown);
        oSelect.selectByValue("4");
        driver.findElement(By.name("postcode")).sendKeys("00000");
        WebElement countrydropDown=driver.findElement(By.name("id_country"));
        Select oSelectC=new Select(countrydropDown);
        oSelectC.selectByVisibleText("United States");
        driver.findElement(By.id("phone_mobile")).sendKeys("0740000000");
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
        driver.findElement(By.name("submitAccount")).click();
        String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();


        if(userText.contains("jucan")) {
            System.out.println("User Verified,Test case Passed");
        }
        else {
            System.out.println("User Verification Failed,Test case Failed");
        }

    }
}
