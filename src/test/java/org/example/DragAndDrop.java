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
@Test(groups = "QA")

public class DragAndDrop {




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
        String URL = "https://the-internet.herokuapp.com/drag_and_drop";
        driver.get(URL);
        driver.manage().window().maximize();


        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);
        //actions.dragAndDrop(from,to).perform();


        //Another Approach to perform drag and drop
        actions.clickAndHold(from).moveToElement(to).release().build().perform();
        Thread.sleep(4000);

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}



