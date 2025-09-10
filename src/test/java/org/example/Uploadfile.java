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

public class Uploadfile {




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
        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);
        driver.manage().window().maximize();

        // file upload is possible if it is input type as 'file'
        WebElement uploadfileinput = driver.findElement(By.id("fileToUpload"));
        uploadfileinput.sendKeys("C:\\Users\\Tanvi\\IdeaProjects\\UIAutomation\\src\\test\\java\\org\\example\\toupload.txt");

        driver.findElement(By.name("submit"));
        Thread.sleep(4000);

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}



