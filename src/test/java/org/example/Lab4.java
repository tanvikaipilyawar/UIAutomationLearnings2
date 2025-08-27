package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Lab4 {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

    //driver.("https://app.vwo.com/#/login");
   // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
// Find the username input field by its ID
    WebElement usernameField = driver.findElement(By.id("login-username"));

    // Get various attributes
    String idValue = usernameField.getAttribute("id");
    String nameValue = usernameField.getAttribute("name");
    String typeValue = usernameField.getAttribute("type");
    String classValue = usernameField.getAttribute("class");
    String dataQaValue = usernameField.getAttribute("data-qa");

// Print them out
System.out.println("id: " + idValue);            // -> login-username
System.out.println("name: " + nameValue);        // -> username
System.out.println("type: " + typeValue);        // -> email
System.out.println("class: " + classValue);      // -> text-input W(100%)
System.out.println("data-qa: " + dataQaValue);    // -> hocewoqisi

}
}
