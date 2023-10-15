package ders_grup;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ders10 {

    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        //WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test() {
        //1) Bir class oluşturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
        //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
        String expectedTitleYoutube = "YouTube";
        String actualTitleYoutube = driver.getTitle();
        Assert.assertTrue(actualTitleYoutube.equals(expectedTitleYoutube));
    }
    @Test
    public void test01() {
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement youtubeLogo = driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue(youtubeLogo.isDisplayed());
    }
    @Test
    public void test02() {
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement aramaKutusu = driver.findElement(By.xpath("//div[@id='search-input']"));
        Assert.assertTrue(aramaKutusu.isEnabled());
    }
    @Test
    public void test03() {
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
        String unexpectedTitleYoutube = "youtube";
        String actualTitleYoutube = driver.getTitle();
        Assert.assertFalse(actualTitleYoutube.equals(unexpectedTitleYoutube));
    }
    @AfterClass
    public static void quit() {
        driver.close();
    }
}
