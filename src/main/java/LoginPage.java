import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "L-UserNameField")
    public WebElement email;

    @FindBy(xpath = "//*[@class='gg-d-24' and @type='password']")
    public WebElement sifre;

    @FindBy(xpath = "//*[@class='gg-m-24 gg-t-24 gg-d-24 gg-w-24 gg-ui-btn-primary gg-ui-btn-fluid  gg-ui-btn-lg']")
    public WebElement girisSayfasındakiButton;


}
