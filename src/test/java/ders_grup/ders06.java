package ders_grup;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ders06 {
    @Test
    public void test(){
        // 1.Yeni bir class olusturalim (Homework)
        // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin
        //         (title) “facebook” oldugunu dogrulayin (verify), degilse dogru basligi
        // yazdirin.
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");

        String expectedTitle = "Facebook";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Facebook title testi passed");
        }else {
            System.out.println("Facebook title testi failed");
        }
        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa
        String expectedUrl = "facebook";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url testi passed");
        }else {
            System.out.println("Url testi failed");
        }
        // “actual” URL’i yazdirin.
        System.out.println(actualUrl);
        // 4.https://www.walmart.com/ sayfasina gidin.
        driver.navigate().to("https://www.walmart.com/");
        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        expectedTitle = "Walmart.com";
        actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Walmart title testi passed");
        }else {
            System.out.println("Walmart title testi failed");
        }
        // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();
        // 7. Sayfayi yenileyin
        driver.navigate().refresh();
        // 8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();
        // 9.Browser’i kapatin
        driver.close();
    }
}
