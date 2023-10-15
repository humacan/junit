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
public class C02_Assertions {
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun
    //   ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        driver.get("https://www.youtube.com");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void titleTesti(){
        String exptitle= "YouTube";
        String acttitle=driver.getTitle();
        Assert.assertEquals(exptitle,acttitle);
    }
    @Test
    public void imageTesti(){
        WebElement logoelement=driver.findElement(By.xpath("(//div[@class='style-scope ytd-topbar-logo-renderer'])[1]"));
        Assert.assertTrue(logoelement.isDisplayed());
    }
    @Test
    public void searchTextboxTesti(){
        WebElement searchboxelement=driver.findElement(By.xpath("//div[@id='search-input']"));
        Assert.assertTrue(searchboxelement.isEnabled());
    }
    @Test
    public void wrongTitleTest(){
        String unexptitle="youtube";
        String acttitle=driver.getTitle();
        Assert.assertNotEquals(unexptitle,acttitle);
    }
}
