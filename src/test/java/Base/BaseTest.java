package Base;
import jdk.jfr.Description;
import objectModels.courierfeadback;
import objectModels.failureDeliverySch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class  BaseTest {
    WebDriver driver;
    private WebDriverWait wait;
    failureDeliverySch failDeliveryS;
    courierfeadback courierFB;

    private By afsaveApartment = By.xpath("//*[@id='address-id-526748']/text()[6]");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "Resources/chromedriver");
        driver = new ChromeDriver();
        failDeliveryS = new failureDeliverySch(driver);
        courierFB= new courierfeadback(driver);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    //Tests
    @Test(description = "TC001 - Page Title is correct")
    @Description("Given I am on Yashry sms confirmation page, Then the correct page title will be displayed.")
    public void navigateToYashryPageAndAssertPageTitle() {
        failDeliveryS.navigateToUrl();
        failDeliveryS.assertPageTitleIsCorrect();
    }
    @Test(description = "TC002 - Order Doesn't contain a refused item")
    @Description("Given Order URL is Valid but order doesn't contain items with status 'refused by customer' then msg'This order doesn't have any items to confirm.' should displayed")
    public void navigateToYashryPageAndAssertNoRefusedItems(){
        failDeliveryS.navigateToUrl();
        failDeliveryS.assertOrderDoesntContainsRefusedItems();
    }

    @Test(description = "TC003 - Order ID is valid")
    @Description("Given Order URL is Valid and order contains items with status 'refused by customer' then items should be displayed")
    public void navigateToYashryPageAndAssertUrlIsValid(){
        failDeliveryS.navigateToUrl();
        failDeliveryS.assertURLisValidWithRefusedItems();
    }
    @Test(description = "TC004 - Order ID is Invalid")
    @Description("Given Order URL is INValid then msg 'Invalid order number 'should be displayed")
    public void navigateToYashryPageAndAssertUrlIsINValid(){
        failDeliveryS.navigateToUrl();
        failDeliveryS.assertOrderIDisInvalid();
    }
    @Test(description = "TC005 - edit shipping address")
    @Description("Given I am on edit shipping address form  when i press on change address Btn then changes should be saved")
    public void editShippingAddress(){
        failDeliveryS.navigateToUrl();
        failDeliveryS.clickEditBtn();
        failDeliveryS.assertGovernorateDropDownOption();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        failDeliveryS.assertCityDropDownOption();
        failDeliveryS.setApartmentField("666");
        failDeliveryS.setBuildingField("111");
        failDeliveryS.setFloorField("444");
        failDeliveryS.setLandmarkField("alex");
        failDeliveryS.setStreetField("222");
        failDeliveryS.setMobileField("+201004781831");
        failDeliveryS.clickChangeBtn();

    }
    @Test(description = "TC006 - cancel the first item and select first cancel reason")
    @Description("")
    public void canceltheFirstItemandSelectReason(){
        failDeliveryS.navigateToUrl();
        failDeliveryS.cancelItemandcheckthatItemCanceled();
    }
    @Test(description = "TC007 - cancel all items and select first feadback option")
    @Description("")
    public void cancelallItemsandSelectFeadbackReason() {
        failDeliveryS.navigateToUrl();
        failDeliveryS.cancelallitems();
        //courierFB.selectCourierFeadback();
    }
    @Test(description = "TC008 - reschedule new runner")
    @Description("")
    public void rescheduleNewRunner() {
        failDeliveryS.navigateToUrl();
        failDeliveryS.clickRescheduleBtn();
        //courierFB.selectCourierFeadback();
    }







}