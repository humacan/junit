package ders_grup;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;
import java.time.Duration;
public class ders01 {
    @Test
    public void test01(){
        //  1. Yeni bir package olusturalim : day01
        // 2. Yeni bir class olusturalim : C03_GetMethods
        System.setProperty("Webdriver.chrome.driver","C:\\Users\\dcsek\\IdeaProjects\\com.Team120_Selenium\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");
        ReusableMethods.bekle(2);
        // 4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());
        // 5. Sayfa basliginin “Amazon” icerdigini test edin
        String expTitleIcerik = "Amazon";
        String actTitle = driver.getTitle();
        Assert.assertTrue(actTitle.contains(expTitleIcerik));
        // 6. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());
        // 7. Sayfa url’inin “amazon” icerdigini test edin.
        String expUrl="amazon";
        String actUrl = driver.getCurrentUrl();
        Assert.assertTrue(actUrl.contains(expUrl));
        // 8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());
        // 9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String expicerik = "shopping";
        String actHTml= driver.getPageSource();
        Assert.assertTrue(actHTml.contains(expicerik));
        // 10. Sayfayi kapatin.
        driver.close();
    }
}
