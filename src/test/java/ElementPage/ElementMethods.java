package ElementPage;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementMethods {

    public WebDriver Driver;

    public ElementMethods(WebDriver driver) {

        Driver = driver;
    }

    public void clickElement(WebElement element) {

        element.click();
    }

    public void fillElement(WebElement element, String value) {
        element.sendKeys(value);

    }

    public void selectValueElement(WebElement element, String value) {
        Select DropDown = new Select(element);
        DropDown.selectByValue(value);


    }

    public void selectTextElement(WebElement element, String value) {
        Select DropDown = new Select(element);
        DropDown.selectByVisibleText(value);

    }

    public void hoverElement(WebElement element){
        Actions action = new Actions(Driver);
        action.moveToElement(element).build().perform();
    }


    public void validateElementText(WebElement element,String value){
        String actualValue=element.getText();
        Assert.assertEquals("Text message is not correct!",value,actualValue);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}