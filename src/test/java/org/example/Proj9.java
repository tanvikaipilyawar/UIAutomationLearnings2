package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Proj9 {

    public static void main(String[] args) {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new EdgeDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // 1) Go to Flipkart
            driver.get("https://www.flipkart.com/");

            // Close login popup only if it appears
            List<WebElement> popups = driver.findElements(By.xpath("//button[contains(text(),'✕')]"));
            if (!popups.isEmpty()) {
                popups.get(0).click();
                System.out.println("Login popup closed.");
            } else {
                System.out.println("Login popup not displayed.");
            }

            // 2) Click on Electronics
            WebElement electronics = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Electronics']")));
            electronics.click();

            // Click on Power Bank link
            WebElement powerbankLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Power Bank')]")));
            powerbankLink.click();

            // 3) Print all product titles
            List<WebElement> titles = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                    By.xpath("//a[@class='IRpwTa' or @class='s1Q9rs' or contains(@class,'_4rR01T')]")));

            System.out.println("Powerbank titles found: " + titles.size());
            for (WebElement title : titles) {
                System.out.println(title.getText());
            }

        } finally {
            driver.quit();
        }
    }
}
