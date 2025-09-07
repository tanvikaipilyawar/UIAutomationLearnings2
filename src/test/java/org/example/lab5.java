package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
@Test(groups = "QA")

public class lab5 {




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
    public void testPositive() {
        driver.manage().window().maximize();
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();


       // Thread.sleep(4000);

           WebElement fromcity = driver.findElement(By.id("fromCity"));

        Actions actions = new Actions(driver);
        actions.moveToElement(fromcity).click().sendKeys("New Delhi").build().perform();

        List<WebElement> list = driver.findElements(By.xpath("//ul[class=\"react-autosuggest__suggestions-list\"]"));

        for(WebElement e :list){
           if( e.getText().contains("New Delhi")) {
               e.click();
               break;
           }

        }

        //svg- scalable vector graphics
        //svg, circle,polygon, path

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}



