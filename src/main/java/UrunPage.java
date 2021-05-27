import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UrunPage extends BasePage{

    @FindBy(xpath = "//*[@class='basket-container robot-header-iconContainer-cart']")
    public WebElement sepet;

    @FindBy(xpath = "//*[@id='sp-price-discountPrice']")
    public WebElement urunFiyat;

    @FindBy(xpath = "//*[@id='add-to-basket']")
    public  WebElement sepeteEkle;

    @FindBy(xpath = "//*[@class='product-new-price']")
    public WebElement sepettekiFiyat;
    @FindBy(xpath = "//*[@class='gg-d-12 pl0']")
    public WebElement sepeteGit;




    public UrunPage(WebDriver driver) {
        super(driver);
    }
}
