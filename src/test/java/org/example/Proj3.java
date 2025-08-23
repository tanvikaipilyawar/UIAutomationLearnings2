package org.example;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Proj3 {

  EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        options.addArguments("--guest");
        driver= new EdgeDriver(options);
    }


    @Test(groups = "QA")
    @Description("Test case description")
    public void openBrowser1(){

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.ebay.com/");
        System.out.println(driver.getTitle());

        driver.manage().window().maximize();

        WebElement searchbox= driver.findElement(By.cssSelector("input[id='gh-ac']"));
        searchbox.sendKeys("macmini");
                //CssSelector("input[id='gh-ac']]"));

        WebElement searchboxbutton= driver.findElement(By.id("gh-search-btn"));
        searchboxbutton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        List<WebElement> searchTitles = driver.findElements(By.cssSelector(".s-item__title"));
//        for (WebElement title : searchTitles){
//            //System.out.println("Titles");
//            System.out.println(title.getText());
//        }

        List<WebElement> searchTitlesPrices = driver.findElements(By.cssSelector(".s-item__price"));
//        for (WebElement prices : searchTitlesPrices){
//            System.out.println(prices.getText());
//        }
        int size = Math.min(searchTitles.size(),searchTitlesPrices.size());
        for(int i=0;i<size;i++){
            System.out.println(searchTitles.get(i).getText()+"||"+searchTitlesPrices.get(i).getText());
        }
    }

    @AfterTest
    public void closeBrowser(){
        //Thread.sleep(5000);
        driver.quit();
    }
}
