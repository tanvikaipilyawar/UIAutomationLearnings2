package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static java.lang.Thread.sleep;

public class Lab2 {

    public static void main(String[] args) {

        EdgeOptions options = new EdgeOptions();
        // Browser = headless (No UI) or full mode
        //1. Headless- No UI, performance good, fast execution
        //2. full mode -UI, performance lag, >100

        //options - browser - start maximize, add extension
        options.addArguments("Maximize");
        WebDriver driver=new EdgeDriver(options);
        driver.get("https://www.google.com/?zx=1755787158371&no_sw_cr=1");
        //Thread.sleep(5000);
        driver.quit();;
    }
}
