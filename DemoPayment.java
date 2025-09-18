package com.juspay.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoPayment {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // ChromeDriver initialize
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void juspayDemoPayment() throws InterruptedException {
        driver.get("https://sandbox.juspay.in/pay/checkout");

        driver.findElement(By.id("card_number")).sendKeys("4111111111111111");
        driver.findElement(By.id("card_expiry")).sendKeys("12/25");
        driver.findElement(By.id("card_cvv")).sendKeys("123");

        driver.findElement(By.id("pay_button")).click();

        // Wait for OTP Page
        Thread.sleep(3000);

        // Enter demo OTP
        WebElement otpBox = driver.findElement(By.id("otp_field"));
        otpBox.sendKeys("123456");

        driver.findElement(By.id("submit_otp")).click();

        // Wait for success page
        Thread.sleep(5000);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}