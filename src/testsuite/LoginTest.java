package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test

    public void verifyUserShouldLoginSuccessfullyWithValidCredentials() {
        //Find the Email Field Enter Email address
        //driver.findElement(By.id("user-name")).sendKeys("standard_user");
        sendTextToElement(By.id("user-name"), "standard_user");
        //Find the password Field and Enter the password
        // driver.findElement(By.name("password")).sendKeys("secret_sauce");
        sendTextToElement(By.name("password"), "secret_sauce");
        //Click on Login Button
       // driver.findElement(By.xpath("//input[@id='login-button']")).click();
        clickOnElement(By.xpath("//input[@id='login-button']"));
//Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.className("title"));
        System.out.println(expectedText);
        Assert.assertEquals("Verify the Text", expectedText, actualText);

    }

    @Test

    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Find the Email Field Enter Email address
        sendTextToElement(By.id("user-name"), "standard_user");
        //Find the password Field and Enter the password
        sendTextToElement(By.name("password"), "secret_sauce");
        //Click on Login Button

        clickOnElement(By.xpath("//input[@id='login-button']"));
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        System.out.println("Total Products are " + elementList.size());

        for (WebElement web : elementList) {
            System.out.println(web.getText());
        }
//Verify that six products are displayed
//on page
        int expectedSize = 6;
        int actualSize = elementList.size();
        Assert.assertEquals("verify the Products", expectedSize, actualSize);


    }

    @After
    public void tearDown() {
        //closeBrowser();
    }


}
