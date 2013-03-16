package training.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class WebDriverTest {
    private WebDriver driver;

    @BeforeMethod
    public void setupWebDriver() {
        driver = new FirefoxDriver();
    }

    @AfterMethod
    public void tearDownWebDriver() {
        if(driver != null) {
            driver.close();
        }
    }

    @Test(description = "Simple Flipkart.com search test", groups = {"smoke","regression"})
    public void testFlipkartSearch() throws InterruptedException {
        String searchText = "Galaxy S3";

        driver.get("http://www.flipkart.com");

        WebElement searchBox = driver.findElement(By.id("fk-top-search-box"));
        searchBox.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.className("fk-main-search-btn"));
        searchButton.click();

        WebElement allResultInfoElement = driver.findElement(By.id("allresults_info"));
        assertTrue(allResultInfoElement.getText().contains(searchText), searchText + "Not found on" +driver.getCurrentUrl());
    }
}
