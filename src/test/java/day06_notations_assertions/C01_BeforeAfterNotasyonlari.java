package day06_notations_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;
import java.time.Duration;
public class C01_BeforeAfterNotasyonlari {
    // 3 test method'u olusturup asagidaki gorevleri
    // bagimsiz olarak calisabilecek sekilde olusturun
    // 1- Amazon anasayfaya gidip, url'in amazon icerdigini test edin,sayfayi kapatin
    // 2- Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
    // 3- Youtube anasayfaya gidip, title'in best icermedigini test edin,sayfayi kapatin
    WebDriver driver; //fclass level da Webdriver olusturduk
    public void setup(){  // setup metodu her teste cagirmak icin olusturduk
        WebDriverManager.chromedriver().setup();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
    }
    @Test
    public void amazonTest(){
        setup();

        driver.get("http://www.amazon.com");
        String expUrlIcerik="amazon";
        String actUrl=driver.getCurrentUrl();
        if (actUrl.contains(expUrlIcerik)) {
            System.out.println("Amazon testi PASSED");

        }else {
            System.out.println("Amazon testi FAILED");
        }
        ReusableMethods.bekle(2);
        driver.close();
    }
    @Test
    public void wiseTesti(){
      //  Wisequarter anasayfaya gidip, title'in Wise icerdigini test edin,sayfayi kapatin
         setup();
         driver.get("https://www.wisequarter.com");
         String expTitleIcerik="Wise";
         String actTitleIcerik=driver.getTitle();

         if (actTitleIcerik.contains(expTitleIcerik)){
             System.out.println("Wisequarter testi PASSED");
         }else {
             System.out.println("Wisequarter testi FAILED");
         }
         driver.close();
    }
    @Test
    public void youtubeTesti(){
        setup();
        driver.get("https://www.youtube.com");
        String unexpTitleIcerik="best";
        String actTitleIcerik=driver.getTitle();

        if (actTitleIcerik.contains(unexpTitleIcerik)){
            System.out.println("Youtube testi FAILED");
        }else {
            System.out.println("Youtube testi PASSED");
        }
        driver.close();
    }
}
