import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class BasePage {

    WebDriverWait wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 500);
        PageFactory.initElements(driver, this);
    }


    public void elementinUstuneGit(WebElement webElement) {

        if (webElement.isDisplayed()) {
            Actions actions = new Actions(driver); //1CFP
            actions.moveToElement(webElement).perform();//1CFP
        }
    }

    public void tiklama(WebElement webElement) throws InterruptedException {
        Thread.sleep(1000);
        webElement.click();
        Thread.sleep(1000);
    }

    public void yaziGirme(String yazi, WebElement webElement) throws InterruptedException {
        Thread.sleep(1000);
        webElement.clear();
        Thread.sleep(1000);
        webElement.sendKeys(yazi);
    }

    public void scrollKaydirma() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void sayfaYuklenmesi() {


        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public void elementeScrollKaydır(WebElement webElement) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public void elementGorunurlugu(WebElement webElement) {

        if (webElement.isDisplayed()) {

        } else {

            Assert.fail();
        }
    }


}


