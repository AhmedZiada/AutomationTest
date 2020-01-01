package objectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class failureDeliverySch  {
    // variables
    private WebDriver driver;
    private WebDriverWait wait;
    private String url = "http://pr-14.acropolis.edfa3ly.io/failed-delivery?orderId=1840080";
    private String title = "Yashry";

    // locators
    private By editBtn = By.cssSelector("#yashry-app > div > div > div > div.pt-0.card > div.card--head--two > div.head--action > button");
    private By buildingField = By.id("building");
    private By streetField = By.id("street");
    private By floorField = By.id("floor");
    private By landmarkField = By.id("landmark");
    private By mobileField = By.id("mobile");
    private By closeBtn = By.xpath("//*[@class='edit-address-form form']//button[@type='button']");
    private By submitBtn = By.cssSelector("body > div.fade.modal.show > div > div > div.modal-body > form > div.modal-footer > button.btn.btn-primary");
    private By cancelItemSpan = By.xpath("//*[@class='content--block']/div[@class='message--alert']/span[1]");
    private By cancelAllItemsSpan = By.xpath("//*[@class='content--block']/div[@class='message--alert']/span[2]");
    private By cancelItemBtn = By.xpath("//*[contains(@class, 'btn-cancel')]");
    private By rescheduleNew = By.xpath("//section[@class='content--block']//button[@type='button']");
    private By statusAlert = By.xpath("//*[@class='fade alert alert-dark show']");
    private By refusedItems = By.xpath("//*[contains(@id, 'refused')]");
    private By damageItems = By.xpath("//*[contains(@id, 'corrupted')]");
    private By statusInvalidOrder = By.xpath("//*[@class='fade alert alert-danger show']");
    private By apartmentField = By.xpath("//*[@id='apartment']");
    private By cityDropDown = By.name("city");
    private By governorDropDown = By.name("governorate");
    private By afsaveBuilding = By.xpath("");
    private By afsaveStreet = By.xpath("");
    private By afsaveFloor = By.xpath("");
    private By afsaveLandmark = By.xpath("");
    private By afsaveGovernorate = By.xpath("");
    private By afsaveCity = By.xpath("");
    private By afsaveMobile = By.xpath("");
    private By afsaveApartment = By.xpath("//*[@id='address-id-526748']/text()[6]");
    private By cancelationReason = By.xpath("//*[@class='checkmark']");
    private By successpopMsg = By.xpath("//*[@class='fade alert alert-success show']");
    private By spinnerloading = By.xpath("//*[@class='spinner-border']");
    private By cancelreasonForm = By.xpath("//*[@class='modal-content']");
    private By cancelationReasonFB = By.xpath("//*[@class='container-radio']");
    private By submitBtnFB = By.xpath("//*[@class='btn btn-primary btn-block btn-lg']");
    private By spinnerloadingFB = By.xpath("//*[@class='spinner-border']");


    // constructor
    public failureDeliverySch(WebDriver driver) { this.driver = driver;this.wait = new WebDriverWait(driver,30);}


    // keywords
    public void navigateToUrl() {
        driver.navigate().to(url);
    }
    public void clickEditBtn(){ wait.until(ExpectedConditions.presenceOfElementLocated(editBtn)).click();}
    public void setBuildingField(String Building){ driver.findElement(buildingField).clear();driver.findElement(buildingField).sendKeys(Building);}
    public void setStreetField(String street){ driver.findElement(streetField).clear();driver.findElement(streetField).sendKeys(street);}
    public void setFloorField(String floor){driver.findElement(floorField).clear();driver.findElement(floorField).sendKeys(floor);}
    public void setApartmentField(String apartment){driver.findElement(apartmentField).clear();driver.findElement(apartmentField).sendKeys(apartment);}
    public void setLandmarkField(String landmark){driver.findElement(landmarkField).clear();driver.findElement(landmarkField).sendKeys(landmark);}
    public void setMobileField(String mobile){ driver.findElement(mobileField).clear();driver.findElement(mobileField).sendKeys(mobile);}
    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }
    public String getAlertInvalidOrder() {
        return driver.findElement(statusInvalidOrder).getText();
    }
    public void clickCloseBtn(){ driver.findElement(closeBtn).click();}
    public void clickChangeBtn(){ driver.findElement(submitBtn).click();}
    public void clickCancelItemBtn(){ driver.findElement(cancelItemSpan).click();}
    public void clickCancelAllBtn(){ driver.findElement(cancelAllItemsSpan).click();}
    public void clickCancelBtn(){ driver.findElement(cancelItemBtn).click();}
    public void clickRescheduleBtn(){ driver.findElement(rescheduleNew).click();}
    public void assertPageTitleIsCorrect() { assertEquals(driver.getTitle(), title); }
    public void assertOrderIDisInvalid(){ Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(statusInvalidOrder)).getText().contains("Invalid order number")); }
    public void assertOrderDoesntContainsRefusedItems(){ assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(statusAlert)).getText(),"This order doesn't have any items to confirm."); }
    public void assertURLisValidWithRefusedItems(){ Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(refusedItems)).isDisplayed());}
    // Governorate
    public void selectFromDropDown(String option){
    findDropDownElement().selectByVisibleText(option); }
    public List<String> getSelectedOptions(){ List<WebElement> selectedElements = findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList()); }
    private Select findDropDownElement(){ return new Select(wait.until(ExpectedConditions.presenceOfElementLocated(governorDropDown))); }
    public void assertGovernorateDropDownOption() {
        String option = "Alexandria";
        selectFromDropDown(option);
        var selectedOptions = getSelectedOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected"); }
    //city
    public void selectCityFromDropDown(String option){ findCityDropDownElement().selectByVisibleText(option); }
    public List<String> getSelectedCityOptions(){ List<WebElement> selectedElements = findCityDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList()); }
    private Select findCityDropDownElement(){ return new Select(wait.until(ExpectedConditions.presenceOfElementLocated(cityDropDown))); }
    public void assertCityDropDownOption() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String option = "Borg AL Arab";
        selectCityFromDropDown(option);
        var selectedOptions = getSelectedCityOptions();
        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option not selected"); }

        public void cancelItemandcheckthatItemCanceled(){
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelItemSpan)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelItemBtn));
            List<WebElement> ItemsBeforeCount = driver.findElements(cancelItemBtn);
            System.out.println(ItemsBeforeCount.size());
            driver.findElement(cancelItemBtn).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelationReason)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerloading));
            driver.findElement(submitBtn).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(successpopMsg));
        }

        public void cancelallitems(){
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelAllItemsSpan)).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelationReason)).click();

            driver.findElement(submitBtn).click();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(cancelreasonForm));
//            driver.findElement(submitBtn).click();
//            return new courierfeadback(driver);
            wait.until(ExpectedConditions.presenceOfElementLocated(cancelationReasonFB)).click();
            driver.findElement(submitBtnFB).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerloadingFB));


        }



}

