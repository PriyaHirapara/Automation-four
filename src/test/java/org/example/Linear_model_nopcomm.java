package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Linear_model_nopcomm {
    static WebDriver driver;
    //static String expectcedMsg = "registration completed";

    public static void waituntilElementislickble(By by, int a) {
        WebDriverWait wait = new WebDriverWait(driver, a);
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }
    public static void sleep1(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void clickonElement(By by) { // method for click element

        driver.findElement(by).click();
    }
    public static String getTextformElement(By by)
    { // method for get text
        return driver.findElement(by).getText();
    }
    public static void selectFromDropDownByVisibleText(By by, String text) { //method for drop down text
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    public static void sendKeyElement(By by, String text) { //method for sendkey
       //driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
    public static void selectFromDropDownByValue(By by, String value){ //methodfor drop down value
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    public static void selectFromDropDownByIndex(By by, int a) { // method for drop down index
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(a);
    }
    public static long timestamp() { //method for timestamp
        return (System.currentTimeMillis());
    }
    @AfterMethod
    public static void browserclose()
    {//method for browser close
        driver.close();
    }
    @BeforeMethod
    public static void setUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");//creating crom driver object to one google crom driver
        driver = new ChromeDriver();// driver web open karse
        driver.manage().window().maximize(); // maxinizing screen
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//applying implisti wait of 20 sec to the driver instnc// if not fouund than take 20 sec to wait if not found than it comes no such element
        driver.get("https://demo.nopcommerce.com/");// open nop commerce web side
    }
    @Test
    public static void verifyUserShouldAbleToRegisterSuccessfully() { //
        clickonElement(By.xpath("//a[@class=\"ico-register\"]")); // click on register
        clickonElement(By.xpath("//div[@id=\"gender\"]")); // select gender
        sendKeyElement(By.xpath("//input[@id =\"FirstName\"]"), "priya");// enter first name
        sendKeyElement(By.xpath("//input[@id =\"LastName\"]"), "hirapara"); // enter last name
        selectFromDropDownByIndex(By.xpath("//select[@name = 'DateOfBirthDay']"), 10);
        selectFromDropDownByVisibleText(By.xpath("//select[@name = 'DateOfBirthMonth']"), "January");
        selectFromDropDownByValue(By.xpath("//select[@name = 'DateOfBirthYear']"), "1920");
        String yourEmail= "Priya11.test+"+timestamp()+"@gmail.com";
        sendKeyElement(By.xpath("//input[@id=\"Email\"]"), yourEmail);

        sendKeyElement(By.xpath("//input[@id=\"Company\"]"),"yogi tex");
        clickonElement(By.xpath("//input[@id=\"Newsletter\"]"));
        sendKeyElement(By.xpath("//input[@id=\"Password\"]"),"Nnstncv@5");
        sendKeyElement(By .xpath("//input[@id=\"ConfirmPassword\"]"),"Nnstncv@5");
       clickonElement(By.xpath("//input[@id=\"register-button\"]"));
        System.out.println(getTextformElement(By.xpath("//div/div[text()=\"Your registration completed\"]")));
       String actualText = getTextformElement(By.xpath("//div[text()=\"Your registration completed\"]")); //get text
        String expectedText = "Your registration completed";
        Assert.assertEquals(actualText,expectedText);
        clickonElement(By.xpath("//input[@name=\"register-continue\"]"));//continue after your registration is completed massage

    }
        @Test(priority = 1)
        public static void VerifyUserShouldAbleToReferaProductToaFriendSuccessfully() {

            clickonElement(By.xpath("//a[@class=\"ico-register\"]")); // click on register
            clickonElement(By.xpath("//div[@id=\"gender\"]")); // select gender
            sendKeyElement(By.xpath("//input[@id =\"FirstName\"]"), "priya");// enter first name
            sendKeyElement(By.xpath("//input[@id =\"LastName\"]"), "hirapara"); // enter last name
            selectFromDropDownByIndex(By.xpath("//select[@name = 'DateOfBirthDay']"), 10);
            selectFromDropDownByVisibleText(By.xpath("//select[@name = 'DateOfBirthMonth']"), "January");
            selectFromDropDownByValue(By.xpath("//select[@name = 'DateOfBirthYear']"), "1920");
            String yourEmail= "Priya11.test+"+timestamp()+"@gmail.com";
            sendKeyElement(By.xpath("//input[@id=\"Email\"]"), yourEmail);
            sendKeyElement(By.xpath("//input[@id=\"Company\"]"),"yogi tex");
            clickonElement(By.xpath("//input[@id=\"Newsletter\"]"));
            sendKeyElement(By.xpath("//input[@id=\"Password\"]"),"Nnstncv@5");
            sendKeyElement(By .xpath("//input[@id=\"ConfirmPassword\"]"),"Nnstncv@5");
            clickonElement(By.xpath("//input[@id=\"register-button\"]"));
            System.out.println(getTextformElement(By.xpath("//div/div[text()=\"Your registration completed\"]")));
            String actualText = getTextformElement(By.xpath("//div[text()=\"Your registration completed\"]")); //get text
            String expectedText = "Your registration completed";
            Assert.assertEquals(actualText,expectedText);
            clickonElement(By.xpath("//input[@name=\"register-continue\"]"));//continue after your registration is completed massage


            clickonElement(By.xpath("//a[text() =\"Computers \"]")); // click on computer
        clickonElement(By.xpath("//a[text() =\" Desktops \"]")); //select on desktop
        clickonElement(By.xpath("//a[text()=\"Digital Storm VANQUISH 3 Custom Performance PC\"]")); // select product
        clickonElement(By.xpath("//input[@value=\"Email a friend\"]")); //click on email a friend box
            String friendEmail ="priya+"+timestamp()+"@gmail.com";
            sendKeyElement(By.xpath("//input[@id=\"FriendEmail\"]"),friendEmail);// Enter the Friends email by using timestamp
            sendKeyElement(By.xpath("//textarea[@id=\"PersonalMessage\"]"), "Enter personal message ");
            clickonElement(By.xpath("//input[@value=\"Send email\"]"));//Only registered customers can use email a friend feature
        String expectedText1 = "Your message has been sent.";
        System.out.println((expectedText1)); //get text
        String actualText1 = getTextformElement(By.xpath("//div[@class =\"result\"]")); //check that test case is pass or not
        Assert.assertEquals(actualText1, expectedText1); //compariion
        System.out.println((actualText1));// actual massage
    }
             @Test(priority = 2)
           public static void UserShouldAbleToAddProductTOBasketSuccessfully () {
                clickonElement(By.xpath("//div[@class =\"header-menu\"]/ul[1]/li[5]/a")); // click on book category
                clickonElement(By.xpath("//div[@class =\"item-grid\"]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]"));
                clickonElement(By.xpath("//span[@class =\"close\"]")); //user need to click on "The product has been added to your shopping cart"
                 clickonElement(By.xpath("//div[@class =\"item-grid\"]/div[2]/div[1]/div[2]/div[3]/div[2]/input[1]")); //
                sleep1(10);
               // waituntilElementislickble(By.xpath("//a[@class=\"ico-cart\"]"),30);
                clickonElement(By.xpath("//a[@class=\"ico-cart\"]")); // click on shopping cart
                 String expectedText3 = "Fahrenheit 451 by Ray Bradbury"; //// get text for first product
                String actualText3 = getTextformElement(By.xpath("//tbody/tr[1]/td[4]/a"));
                Assert.assertEquals(actualText3,expectedText3);
                System.out.println(actualText3);
                String expectedText2 = "First Prize Pies";// get text for second text
                String actualText2 = getTextformElement(By.xpath("//tbody/tr[2]/td[4]/a"));
                Assert.assertEquals(actualText2,expectedText2); // assert for this two product

    }

        }




