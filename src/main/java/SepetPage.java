import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SepetPage extends BasePage{

    @FindBy(xpath = "//*[@class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']")
    public WebElement silinmeKontrol;

    @FindBy(xpath = "//*[text()='Ürün Toplamı (2 Adet)']")
    public WebElement adetKontrol;
    public SepetPage(WebDriver driver) {
        super(driver);
    }
}
