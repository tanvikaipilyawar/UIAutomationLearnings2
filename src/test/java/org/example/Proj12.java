package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Proj12 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options= new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver=new EdgeDriver(options);

    }

    @Test(groups = "QA")
    @Description("descrption")
    public void testPositive() throws InterruptedException {
        String URL = "https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open";

        driver.manage().window().maximize();

        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("iframeResult"));


        //driver.switchTo().frame("iframeResult");
        WebElement frameElement = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(frameElement);


        driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();

        // Get the parent window handle
        String parentWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> allwindows = driver.getWindowHandles();

        for(String handle: allwindows){
            if(!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                System.out.println("child window handle"+driver.getTitle());

                driver.close();
            }
        }
       driver.quit();


    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



    ////div[contains(@data-testid,'autocomplete-dropdown')]/div/div[contains(text(),'DEL')]
}
