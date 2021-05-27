import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'2')]")
    public WebElement sayfaNumarasi;

    @FindBy(id = "//*[@class='gg-uw-6 gg-w-8 gg-d-8 gg-t-8 gg-m-24 gg-mw-12 catalog-seem-cell srp-item-list  browser'][1]")
    public WebElement urun;


    public SearchPage(WebDriver driver) {
        super(driver);
    }


}
