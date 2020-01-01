package objectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class courierfeadback {

    private By cancelationReasonFB = By.xpath("//*[@class='container-radio']");
    private By submitBtnFB = By.xpath("//*[@class='btn btn-primary btn-block btn-lg']");
    private By spinnerloadingFB = By.xpath("//*[@class='spinner-border']");


    private WebDriver driver;
    private WebDriverWait wait;
    public courierfeadback(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,60);
    }

    public void selectCourierFeadback(){
        wait.until(ExpectedConditions.presenceOfElementLocated(cancelationReasonFB)).click();
        driver.findElement(submitBtnFB).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinnerloadingFB));

    }



}
