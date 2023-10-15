package day06_notations_assertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;
public class Assertions {
    //Amazon anasayfaya gidin
    //3 farkli test methodu olusturarak asagidaki gorevleri yapin
    //1-Title in Amazon icerdigini test edin
    //2-Arama cubuguna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    //3-Ilk urunu tiklayin ve urun isminde Nutella gectigini test edin
     /*
        JUnit test method'lari icinde yapilan testlerin
        failed veya passed oldugunu bize raporlar
        Ancak bu raporlama
        kodlar sorunsuz calisip bittiyse PASSED
        exception ile karsilasilirsa FAILED olarak gerceklesir
        Ayrica JUnit test method'lari icinde yapilan testleri degil
        method'lari raporlar
        JUnit bu is icin Assertion class'i olusturmustur
        Bir test method'unun icinde
        birden fazla assertion varsa
        bu assertion'lardan bir tanesi FAILED olursa
        kodun calismasi o satirda durur
        geriye kalan assertion'lar kontrol edilmemis olur
        Eger bir class calistiginda
        tum assertion'larin mutlaka gozden gecirilmesini istiyorsak
        her assertion icin ayri test method'u olusturabiliriz
        test method'larinin ismi de
        yaptigi is ile uyumlu olursa
        konsolda neyin calisip neyin calismadigini kolayca gorebiliriz
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

        Assert.assertTrue("Title Ramazon icermiyor",actTitle.contains(expTitleicerik));
        //test fail olursa aciklama yukaridaki gibi olucak, pass olursa ilk virgul cumlesi gozukmeyecek
        System.out.println("Bu satir test PASS olursa calisir FAIL olursa calismaz");

    }
    @Test
    public void nutellaTest(){
        //arama kutusuna  "NUtella" yazip aratin ve sonucun java icerdigini test edin
        WebElement aramakutu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutu.clear(); // arama oncesi arama kutusunu temizler
        aramakutu.sendKeys("Nutella"+ Keys.ENTER);

        ReusableMethods.bekle(2);

        WebElement sonucYazielement=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1] "));
        String expSonucicerik="Kutella";
        String actSonucyazisi=sonucYazielement.getText();

         Assert.assertTrue(actSonucyazisi.contains(expSonucicerik));

    }
    @Test
    public void javaTesti(){
        //arama kutusuna "java" yazip aratin ve sonucun java icerdigini test edin

        WebElement aramakutu= driver.findElement(By.id("twotabsearchtextbox"));
        aramakutu.clear(); // onceki test oncesi arama kutusunu temizledik
        aramakutu.sendKeys("Java"+ Keys.ENTER);
        ReusableMethods.bekle(2);

        WebElement sonucYazielement=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1] "));
        String expSonucicerik="Tava";
        String actSonucyazisi=sonucYazielement.getText();

        Assert.assertTrue(actSonucyazisi.contains(expSonucicerik));
    }
}
