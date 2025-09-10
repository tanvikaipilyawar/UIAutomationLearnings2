package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

@Test(groups = "QA")

public class WindowHandling {




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
        driver.manage().window().maximize();
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();

        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Before click"+mainWindowHandle);
        WebElement link = driver.findElement(By.linkText("Click Here"));

// All the Windows Tab have unique name
        Set<String> windowhandles = driver.getWindowHandles();
        for(String handle :windowhandles){
            driver.switchTo().window(handle);
            System.out.println(handle);

            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test Case passed");
            }
        }

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}



