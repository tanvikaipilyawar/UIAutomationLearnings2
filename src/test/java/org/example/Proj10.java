package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Proj10 {


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
        String URL = "https://awesomeqa.com/practice.html";
        driver.get(URL);
        driver.manage().window().maximize();

        //to sent in Capital
        //shift(keydown) --> the testing Academy - > Shift(keyup)
         //driver.findElement(By.name("firstname")).sendKeys("cade");

        Actions actions = new Actions(driver);
         actions.keyDown(Keys.SHIFT).sendKeys("Tanvi").keyUp(Keys.SHIFT);

        WebElement link = driver.findElement(By.xpath("//a[contains(text(),\"Click here to Download File\")]"));
        actions.build().perform();

                Thread.sleep(13000);

    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }


}
