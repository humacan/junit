package ders_grup;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ders04 {
    @Test
    public void test(){
        //1. Yeni bir class olusturun (TekrarTesti)
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        WebDriver driver = new ChromeDriver();
        driver.get("https://youtube.com");
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Youtube title testi passed");
        }else {
            System.out.println("Youtube title testi failed");
        }
        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Youtube url testi passed");
        }else {
            System.out.println("Youtube url testi failed");
        }
        //doğru URL'yi yazdırın.
        System.out.println(actualUrl);
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://amazon.com");
        //5. Youtube sayfasina geri donun
        driver.navigate().back();
        //6. Sayfayi yenileyin
        driver.navigate().refresh();
        //7. Amazon sayfasina donun
        driver.navigate().forward();
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        expectedTitle = "Amazon";
        actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Amazon title testi passed");
        }else {
            System.out.println("Amazon title testi failed");
            System.out.println(actualTitle);
        }
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //doğru URL'yi yazdırın
        expectedUrl = "https://www.amazon.com/";
        actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)){
            System.out.println("Amazon url testi passed");
        }else {
            System.out.println("Amazon url testi failed");
        }
        //11.Sayfayi kapatin
        driver.close();
    }
}
