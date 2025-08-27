package org.example;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Proj4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

      //  Instead of sendkeys() is there any other option in selenium

        //Option 1- Using JavaScriptExecutor
//You can directly set a value in an input field using JavaScript. This is faster and bypasses some issues where sendKeys() fails (e.g., hidden elements, React-controlled fields).
        // Find elements
        WebElement username = driver.findElement(By.id("login-username"));
        WebElement password = driver.findElement(By.id("login-password"));
        WebElement loginBtn = driver.findElement(By.id("js-login-btn"));

        // Create JS Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Set values directly
        js.executeScript("arguments[0].value='testUser';", username);
        js.executeScript("arguments[0].value='pass123';", password);

        // Click login button
        js.executeScript("arguments[0].click();", loginBtn);
    }
}
