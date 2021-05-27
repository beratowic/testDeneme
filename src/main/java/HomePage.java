import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@class='sc-4995aq-4 dNPmGY']/input")
    public WebElement aramayeri;

    @FindBy(xpath = "//*[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']/span")
    public WebElement bulbutton;

    @FindBy(xpath = "//*[@class='sc-12t95ss-3 fDarBX']")
    public WebElement girisButton;

    @FindBy(xpath = "//*[@class='gekhq4-0 koEZsC']")
    public WebElement uzerineGidilecek;



    public void elementinUstuneGit() {
        elementinUstuneGit(uzerineGidilecek);
    };

    public HomePage(WebDriver driver) {
        super(driver);
    }

}
