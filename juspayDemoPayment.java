package com.juspay.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JuspayDemoPayment {
    public static void main(String[] args) throws InterruptedException {
        // Setup Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

       
        driver.get("https://sandbox.juspay.in/");

 

        // Step 2: Example - payment button click
        WebElement startPayment = driver.findElement(By.xpath("//button[contains(text(),'Pay')]"));
        startPayment.click();

        Thread.sleep(3000);

        // Step 3: 
        driver.findElement(By.name("card_number")).sendKeys("4111111111111111");
        driver.findElement(By.name("name_on_card")).sendKeys("Test User");
        driver.findElement(By.name("card_exp_month")).sendKeys("12");
        driver.findElement(By.name("card_exp_year")).sendKeys("25");
        driver.findElement(By.name("card_security_code")).sendKeys("123");

        driver.findElement(By.xpath("//button[contains(text(),'Pay Now')]")).click();

        Thread.sleep(3000);

        
        driver.switchTo().frame("juspay_iframe");
        driver.findElement(By.name("otp")).sendKeys("123456");

        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

        System.out.println("✅ Juspay payment flow automation completed till OTP!");

        Thread.sleep(5000);
        driver.quit();
    }
}