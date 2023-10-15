package day06_notations_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;
import java.time.Duration;
public class C02_BeforeAfterNotasyonu {
    /* bir class in icinde her test method undan once calismasini istediginiz
    siradan bir method varsa o method un basina @Before kullanirsak
    @Test method larinda cagirmaya gerke olmadan o method her test method unda
    once calisirf
     */
    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
    WebDriver driver=new ChromeDriver(); //fclass level da Webdriver olusturduk

    @Before
    public void setup(){  // setup metodu her teste cagirmak icin olusturduk
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    @After
    public void teardown(){
        ReusableMethods.bekle(2);
        driver.close();
    }


    @Test
    public void amazonTest() {

        driver.get("http://www.amazon.com");
        String expUrlIcerik = "amazon";
        String actUrl = driver.getCurrentUrl();
        if (actUrl.contains(expUrlIcerik)) {
            System.out.println("Amazon testi PASSED");

        } else {
            System.out.println("Amazon testi FAILED");
        }
    }
    @Test
    public void wiseTesti() {
        //  Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
        driver.get("https://www.wisequarter.com");
        String expTitleIcerik = "Wise";
        String actTitleIcerik = driver.getTitle();

        if (actTitleIcerik.contains(expTitleIcerik)) {
            System.out.println("Wisequarter testi PASSED");
        } else {
            System.out.println("Wisequarter testi FAILED");
        }
    }
    @Test
    public void youtubeTesti() {

        driver.get("https://www.youtube.com");
        String unexpTitleIcerik = "best";
        String actTitleIcerik = driver.getTitle();

        if (actTitleIcerik.contains(unexpTitleIcerik)) {
            System.out.println("Youtube testi FAILED");
        } else {
            System.out.println("Youtube testi PASSED");
        }
    }
}