package Test;

import Base.BaseTest;
import ElementPage.LoginPage;
import org.junit.Assert;
import org.junit.Test;

public class LoginTests extends BaseTest {

    @Test
    public void SuccessfulLoginTest() {
       LoginPage homePage = new LoginPage();

        driver.findElement(homePage.signInButton).click();
        homePage.Login("paulici_84@yahoo.com", "parola123");

        Assert.assertEquals("Paula Jucan", driver.findElement(homePage.loggedUsername).getText());



    }
}
