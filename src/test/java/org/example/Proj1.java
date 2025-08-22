package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Proj1
{

    @Test
    public void makeApp(){
        WebDriver driver= new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        // btn-make-appointment

        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"CURA Healthcare Service");
        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment = driver.findElement(By.id("btn-make-appointment"));
        makeAppointment.click();

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        WebElement username = driver.findElement(By.id("txt-username"));
        username.sendKeys("John Doe");

        WebElement password = driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement login = driver.findElement(By.id("btn-login"));
        login.click();


        WebElement heading = driver.findElement(By.xpath("//h2[text()='Make Appointment']"));

        if (heading.isDisplayed()) {
            System.out.println("✅ 'Make Appointment' text is displayed!");
        } else {
            System.out.println("❌ Text not found!");
        }

    }

}
