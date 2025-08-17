package org.example;

import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Lab1 {

    @Test
    public void vwoLogin(){
        EdgeDriver driver = new EdgeDriver();
        driver.get("https://mvnrepository.com/artifact/io.qameta.allure/allure-testng/2.29.1");
        driver.quit();
    }
}

//Selenium Flow
//1. Create Session; session id gets created (line 10)
// Client Java Program
// Server Webdriver Edge - Command w3c -> Edge Browser
//2. Session -> Run the commands -> GET Command (line 11)- w3c Protocol
//3. Edge Driver (tell) the Edge Browser
//4. Open Fresh copy of Edge browser and Open the URL
//5. Driver - Command (POST) Request -> Shutdown the browser. Id = null


// 3 Scenarios

//1. If you want to run chrome & Edge browser
//         EdgeDriver driver = new EdgeDriver();
//        ChromeDriver driver = new ChromeDriver();

//2. if you want to run on chrome then change it to Edge
//        WebDriver driver = new ChromeDriver();
 //       driver = new EdgeDriver();

//3. If you want to run on multiple browser
// RemoteWebDriver driver
//


// In selenium 3 we need to set the path of the driver
//driver.setproperty("webdriver.chrome.driver","path");
//driver.get(url);

//Selenium 4 uses Selenium manager + w3c protocol. no need to set path for the driver