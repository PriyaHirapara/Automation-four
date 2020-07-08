import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Regist_HW1 {
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
    public static void clickonElement(By by) {

        driver.findElement(by).click();
    }
    public static String getTextformElement (By by) {
        return driver.findElement(by).getText();
    }

    public static void SelectFromDropDownByVisibleText(By by, String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }

    public static void SendKeyElement(By by, String text) {
        driver.findElement(by).sendKeys();
    }

    public static void SelectFromDropDownByValue(By by,String value){
        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    public static void SelectFromDropDownByIndex(By by,int a){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(a);
    }
    public static long timestamp(){
        return (System.currentTimeMillis());
    }
    public static void browserclose() {
        driver.close();
    }

    // @BeforeMethod
    public static void setUpBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\soft\\chromedriver.exe");//creating crom driver object to one google crom driver
        driver = new ChromeDriver();// driver web open karse
        driver.manage().window().maximize(); // maxinizing screen
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//applying implisti wait of 20 sec to the driver instnc// if not fouund than take 20 sec to wait if not found than it comes no such element
        driver.get("https://demo.nopcommerce.com/");// open nop commerce web side
    }
    // @Test
    public static void main(){
        // public  static void verifyUserShouldAbleToRegisterSuccessfully(){//setting up crom driver path

        clickonElement(By.xpath("//a[@class=\"ico-register\"]"));
        clickonElement(By.xpath("//div[@id=\"gender\"]"));
        SendKeyElement(By.xpath("//input[@id =\"FirstName\"]"),"priya");
        SendKeyElement(By.xpath("//input[@id =\"LastName\"]"),"hirapara");
        //driver.findElement(By.xpath("//input[@name=\"LastName\"]")).sendKeys("hirapara");
        SelectFromDropDownByIndex(By.xpath("//select[@name = 'DateOfBirthDay']"), 10);
        SelectFromDropDownByVisibleText(By.xpath("//select[@name = 'DateOfBirthMonth']"), "January");
        //clickonElement(By.xpath("//select[@name = 'DateOfBirthYear']"));
        SelectFromDropDownByValue(By.xpath("//select[@name = 'DateOfBirthYear']"), "1920");

        //SelectFromDropDownByValue(By.xpath("//select[@name = 'DateOfBirthYear']"),"2010");
        // String emial = "test+" + timestamp()+ "@gmail.com";
        SendKeyElement(By.xpath("//input[@id=\"Email\"]"),"priya.test@gmail.com");
        SendKeyElement(By.xpath("//input[@id=\"Company\"]"),"yogi tex");



//input[@id="Company"]
        clickonElement(By.xpath("//input[@id=\"register-button\"]"));
        String pageText=getTextformElement(By.xpath("//div/strong"));
        System.out.println(pageText);
//input[@name = 'Email']



        //clickonElement(By.xpath("//a[text () =\"Computers \"] "));
        // driver.findElement(By.xpath("//a[text () =\"Computers \"] ")).click();//click on computer link
        //clickonElement(By.xpath("//a[text() =\" Desktops \"]"));
        // String actualText = getTextformElement(By.xpath("//a[text()=\"Build your own computer\"]"));
        //String expectedText = "Build your own computer";
//select[@name = 'DateOfBirthDay']

        //Assert.assertEquals(actualText,expectedText);
        //Assert.assertTrue("asdvnj");

        //String pagetext= driver.findElement(By.xpath("//div[@class=\"page-body\"]/div[1]/div[1]/div[1]/div[1]")).getText();
        // System.out.print(actualText);
        driver.close();
    }}


