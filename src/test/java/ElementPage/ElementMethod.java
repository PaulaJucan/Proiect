package ElementPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ElementMethod {

    public WebDriver Driver;

    public ElementMethod(WebDriver driver) {

        Driver = driver;
    }

    public void clickElement(WebElement element){

        element.click();
    }

    public void fillElement(WebElement element, String value){
        element.sendKeys(value);

    }

    public void selectValueElement(WebElement element, String value){
        Select DropDown = new Select(element);
        DropDown.selectByValue(value);
    }

    public void selectTextElement(WebElement element, String value){
        Select DropDown = new Select(element);
        DropDown.selectByVisibleText(value);
    }

    public void hoverElement(WebElement element){
        Actions action = new Actions(Driver);
        action.moveToElement(element).build().perform();
    }


}