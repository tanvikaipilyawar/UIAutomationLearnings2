package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Proj14 {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
        searchBox.sendKeys("Test Java");

        searchBox.sendKeys(Keys.ENTER); // press Enter instead of clicking button


        WebElement result = driver.findElement(By.xpath("//span[@class=\"Ty0Rrc z1asCe MZy1Rb\"]"));


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", result);

//       ((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true)", result)

    }
}
