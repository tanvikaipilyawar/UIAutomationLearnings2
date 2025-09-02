package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

//handle multiple windows
public class Proj5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement linkedinLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(@href,'linkedin')]")
        ));
        linkedinLink.click();

        // Get the main window handle
        String mainWindow = driver.getWindowHandle();

        Set<String> allWindows =driver.getWindowHandles();

        for(String window: allWindows){
            if(!window.equals(mainWindow)){
                // Switch to child window
                  driver.switchTo().window(window);
                System.out.println("Child Window Title: " + driver.getTitle());


                // Perform actions in child window
//driver.findElement(By.xpath("//a[text()='Contact Sales']")).click();

                // Wait until Contact Sales button is visible and clickable
                WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement contactSalesBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[contains(text(),'Contact Sales')]")
                ));
                contactSalesBtn.click();


                Thread.sleep(3000);

                // Close child window
                // Close child window
               driver.close();

            }
        }



        //switch back to main window
        driver.switchTo().window(mainWindow);
        System.out.println("Main Window title" +driver.getTitle());
        driver.quit();
    }}

//Always switch back to main window after handling child windows.
//getWindowHandle() → returns the current window ID.
//getWindowHandles() → returns all open windows IDs in a Set<String>.
//Use driver.switchTo().window(windowID) to move between windows.