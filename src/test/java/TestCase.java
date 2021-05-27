import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase extends BaseTest {

    final static Logger log = Logger.getLogger(TestCase.class);

    @Test
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/beratow/Download/chromedriver/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gittigidiyor.com/");
        driver.manage().window().maximize();
        log.info("chorme driverı açtıktan sonra ekranı büyütür");

        String sayfaBasligi = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String simdikiSayfaBasligi = driver.getTitle();
        if (sayfaBasligi.equals(simdikiSayfaBasligi)) {

        } else {
            Assert.fail();

        }
        log.info("Sayfa doğrulandı");

        HomePage homePage = new HomePage(driver);


        try {
            homePage.elementinUstuneGit();
            Thread.sleep(1000);
            homePage.elementinUstuneGit(homePage.girisButton);
            Thread.sleep(1000);
            homePage.tiklama(homePage.girisButton);
        } catch (Exception e) {
            System.out.println("Sayfaya giriş yapılamadı");
            Assert.fail();
        }
        log.info("Login sayfası açıldı");

        LoginPage loginPage = new LoginPage(driver);

        try {

            Thread.sleep(1000);
            loginPage.yaziGirme("projegtgdyr@gmail.com;", loginPage.email);
            Thread.sleep(1000);
            loginPage.yaziGirme("prj123456/", loginPage.sifre);
            Thread.sleep(1000);
            loginPage.tiklama(loginPage.girisSayfasındakiButton);


        } catch (Exception e) {
            System.out.println("Kullancı adı ve şifre hatalı ");
            Assert.fail();
        }

        log.info("Siteye üyelik girişi yapıldı");

        Thread.sleep(2000);
        String loginSayfasıBasligi = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String simdikiLoginSayfasininBasligi = driver.getTitle();

        if (loginSayfasıBasligi.equals(simdikiLoginSayfasininBasligi)) {

        } else {
            Assert.fail();
        }
        log.info("Üyelik girişi sayfası doğrulandı");

        homePage.yaziGirme("bilgisayar", homePage.aramayeri);
        Thread.sleep(2000);
        homePage.tiklama(homePage.bulbutton);
        Thread.sleep(1000);
        SearchPage searchPage = new SearchPage(driver);
        Thread.sleep(1000);
        searchPage.scrollKaydirma();
        Thread.sleep(1000);
        searchPage.tiklama(searchPage.sayfaNumarasi);

        log.info("Arama kutucuğuna bilgisayar yazıldı ve arama butonuna tıklanıldı.Sayfanın en aşağısına inildi ve 2.sayfaya tıklanıldı");

        searchPage.sayfaYuklenmesi();
        String searchPageSayfaBasligi = "Bilgisayar - GittiGidiyor - 2/100";
        String simdikiSearchPageSayfaBasligi = driver.getTitle();

        if (searchPageSayfaBasligi.equals(simdikiSearchPageSayfaBasligi)) {
            Thread.sleep(1000);
            searchPage.tiklama(searchPage.urun);
            Thread.sleep(1000);
        } else {
            Assert.fail();
        }
        log.info("Arama yapılan sayfa doğrulandı ve ürüne tıklanıldı");

        UrunPage urunPage = new UrunPage(driver);

        String urunfiyati = urunPage.urunFiyat.getText();
        searchPage.elementeScrollKaydır(urunPage.sepeteEkle);
        urunPage.tiklama(urunPage.sepeteEkle);
        Thread.sleep(1000);
        String test1 = urunPage.sepettekiFiyat.getText();

        log.info("Sepete ekleye tıklandı.");

        if (urunfiyati.equals(test1)) {
            searchPage.elementeScrollKaydır(urunPage.sepeteEkle);
            urunPage.tiklama(urunPage.sepeteEkle);
            urunPage.elementinUstuneGit(urunPage.sepet);
            urunPage.tiklama(urunPage.sepeteGit);
        } else {
            Assert.fail();
        }

        log.info("Ürün fıyatı ve sepetteki fiyat kontrol edildi.Sepete bir ürün daha eklendi.Sepete gidildi.");

        SepetPage sepetPage = new SepetPage(driver);
        sepetPage.elementGorunurlugu(sepetPage.adetKontrol);

        log.info("Sepette 2 adet ürün olduğu doğrulandı");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('a.btn-delete.btn-update-item',':before').click();");
        Thread.sleep(1000);
        sepetPage.elementGorunurlugu(sepetPage.silinmeKontrol);

        log.info("Ürün sepetten silindi ve silindiği doğrulandı");


    }


}
