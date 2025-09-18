package com.juspay.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PaymentTest {

    public void testPaymentJourney() throws InterruptedException {
        // Chrome driver setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Step 1: Open Flipkart
        driver.get("https://www.flipkart.com");

      
        try {
            WebElement closeBtn = driver.findElement(By.xpath("//button[contains(text(),'✕')]"));
            closeBtn.click();
        } catch (Exception e) {
            System.out.println("No popup appeared.");
        }

        // Step 3: Search for a product
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();

        Thread.sleep(3000);

        // Step 4: Validate result
        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
        if (result.isDisplayed()) {
            System.out.println("✔ Test Passed: Search working fine");
        } else {
            System.out.println("✘ Test Failed: No results");
        }

        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        PaymentTest t = new PaymentTest();
        t.testPaymentJourney();
    }
}