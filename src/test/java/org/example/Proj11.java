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

public class Proj11 {
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
        String URL = "https://www.spicejet.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement Del = driver.findElement(By.xpath("//div[data-testid=\"search-source-code\"]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(Del).click().build().perform();
        actions.moveToElement(Del).click().sendKeys("Del").build().perform();


    }


    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



    ////div[contains(@data-testid,'autocomplete-dropdown')]/div/div[contains(text(),'DEL')]
}
