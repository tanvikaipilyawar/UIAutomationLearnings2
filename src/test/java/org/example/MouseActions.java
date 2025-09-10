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

public class MouseActions {




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


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Switch to frame if popup is inside one (MakeMyTrip uses iframe sometimes)
            driver.switchTo().defaultContent();
            WebElement closePopup = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("span.commonModal__close")));

            // Wait for the close button on login popup
            //WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class=\"imageSlideContainer\"]"))));

            closePopup.click();
            System.out.println("Popup dismissed");

        } catch (Exception e) {
            System.out.println("Popup not displayed: " + e.getMessage());
        }





        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        System.out.println("Scrolling down");

    }

    @AfterTest
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}



