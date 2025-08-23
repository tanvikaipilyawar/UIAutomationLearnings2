package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Proj2 {


    @Test
    public void testloginPositive(){
        WebDriver driver= new ChromeDriver();
        try{
        driver.get("https://www.idrive360.com/enterprise/login");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("username"));
        email.sendKeys("augtest_040823@idrive.com");

        //WebElement username = driver.findElement(By.id("username")); // check if actual id is 'username'
        //username.sendKeys("your_email@example.com");

        WebElement password = driver.findElement(By.id("password"));
       password.sendKeys("123456");

       WebElement signin = driver.findElement(By.id("frm-btn"));
        signin.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your free trial has expired')]"))
        );

        // verify text
        String actualText = message.getText();
        if (actualText.contains("Your free trial has expired")) {
            System.out.println("✅ Verification Passed: Message displayed");
        } else {
            System.out.println("❌ Verification Failed: Message not found");
        }

    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        driver.quit();
    }

}
}

// link text & partial link only work with a tag anchor