package org.example.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class lab1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
      //  driver.findElement(By.id("userEmail")).sendKeys("rahul");
        //driver.findElement(By.id("userPassword")).sendKeys("hello123");
      //  driver.findElement(By.id("login")).click();

       // WebElement msg = driver.findElement(By.xpath("*Email is required"));
      //  assertEquals("*Email is required", msg);

        driver.findElement(By.linkText("Forgot password?")).click();

    }




}
