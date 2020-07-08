package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Regis_Autom { static WebDriver driver;
    static String expectcedMsg = "registration completed";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
        driver.findElement(By.id("FirstName")).sendKeys("priya");
        driver.findElement(By.xpath("//input[@name=\"LastName\"]")).sendKeys("hirapara");
        driver.findElement(By.xpath("//input[@id=\"register-button\"]")).click();
        String pageText=driver.findElement(By.xpath("//div/strong")).getText();
        System.out.println(pageText);
        //String actualMsg = driver.findElements(By.partialLinkText("result")).g

    }

}

