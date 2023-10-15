package day06_notations_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
public class C03_BeforeClass_AfterClass {
    //Amazon anasayfaya gidin
    //3 farkli test methodu olusturarak asagidaki gorevleri yapin
    //1-Title in Amazon icerdigini test edin
    //2-Arama cubuguna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    //3-Ilk urunu tiklayin ve urun isminde Nutella gectigini test edin
    /*Bize verilen gorevde olusturulacak farkli test methodlari ayni web sayfasinda oluyorsa
    her test method unda yeniden driver olusturup, sonunda kapatmak yerine
    tum @Test method larindan once 1 kere driver olustrup
    tum @Test method larini calistirip
    en son driver i kapatmak daha mantili olur
     */ /*
    @BeforeClass ve @Afterclass notasyonlari kullanildiginda DIKKAT etmemiz gereken konu bu notasyonlari
    kullanan method larin static olarakk isaretlenmesinin zorunlu olmasidir
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void titleTest(){
        //arama kutusuna  "Amazon" yazip aratin ve sonucun java icerdigini test edin
        String expTitleicerik="Amazon";
        String actTitle=driver.getTitle();
        if (actTitle.contains(expTitleicerik)){
            System.out.println("Title test PASSED");
        }else {
            System.out.println("Title test FAILED");
        }
    }
    @Test
    public void nutellaTest(){
        //arama kutusuna  "NUtella" yazip aratin ve sonucun java icerdigini test edin
        WebElement aramakutu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutu.clear(); // arama oncesi arama kutusunu temizler
        aramakutu.sendKeys("Nutella"+ Keys.ENTER);

        ReusableMethods.bekle(2);

        WebElement sonucYazielement=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1] "));
        String expSonucicerik="Nutella";
        String actSonucyazisi=sonucYazielement.getText();

        if (actSonucyazisi.contains(expSonucicerik)){
            System.out.println("Nutella testi PASSED");
        }else {
            System.out.println("Nutella testi FAILED");
        }

    }
    @Test
    public void javaTesti(){
        //arama kutusuna "java" yazip aratin ve sonucun java icerdigini test edin

        WebElement aramakutu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutu.clear(); // onceki test oncesi arama kutusunu temizledik
        aramakutu.sendKeys("Java    "+ Keys.ENTER);
        ReusableMethods.bekle(2);

        WebElement sonucYazielement=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1] "));
        String expSonucicerik="Java";
        String actSonucyazisi=sonucYazielement.getText();

        if (actSonucyazisi.contains(expSonucicerik)){
            System.out.println("Java testi PASSED");
        }else {
            System.out.println("Java testi FAILED");
        }
    }
}
