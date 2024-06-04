package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

/**
 * 3. Create the package ‘testsuite’ and create the
 * following class inside the ‘testsuite’ package.
 * <p>
 * 1. LoginTest
 * <p>
 * 4. Write down the following test into ‘LoginTest’
 * class
 * 1. userSholdLoginSuccessfullyWithValid
 * <p>
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * <p>
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * <p>
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */

public class LoginTest extends Utility {

    @Before
    public void setUp() {
        logIn(browser);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter Username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // Enter password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        // Click on Login button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify the text “Products”
        Assert.assertEquals("Text didn't match!", "Products", getTextFromElement(By.xpath("//span[@class='title']")));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter Username
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        // Enter password
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        // Click on Login button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        // Verify that six products are displayed on page
        List<WebElement> productElementList = driver.findElements(By.className("inventory_item"));
        System.out.println("Total Products on the page are: " + productElementList.size());
        Assert.assertEquals("Number of products did not match!", productElementList.size(), 6);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}































