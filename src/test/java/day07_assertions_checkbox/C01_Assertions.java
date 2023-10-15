package day07_assertions_checkbox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class C01_Assertions {
    // https://www.bestbuy.com/ adresine gidin
    // farkli test method lari olusturarak asagidaki testleri yapin
    //  -sayfa URL niin https://www.bestbuy.com/ a esit oldugunu test edin
    //  -titletest=> sayfa basliginin "Best" iceermedigini (contains ile)test edin
    //  -logotest => bestbuy logosunun goruntulendigini test edin
    //  -FrancaisLinkTest => Fransizca linkin goruntulendiginin test edin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void teardown(){
    driver.close();
    }
    @Test
    public void urlTest(){
        String expurl="https://www.bestbuy.com/";
        String actUrl=driver.getCurrentUrl();

        Assert.assertEquals(expurl,actUrl);
    }
    @Test
    public void titleTest(){
        String unexpIcerik="Best";
        String actTitle=driver.getTitle();

        Assert.assertFalse(actTitle.contains(unexpIcerik));
    }
    @Test
    public void logoTest(){
        WebElement logoelement=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoelement.isDisplayed());
    }
    @Test
    public void francaisTesti(){
        WebElement fransizLinkElement=driver.findElement(By.xpath("//button[normalize-space()='Français']"));
        Assert.assertTrue(fransizLinkElement.isDisplayed());
    }

}
