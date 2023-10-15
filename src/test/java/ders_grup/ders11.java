package ders_grup;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;
public class ders11 extends TestBase {
    @Test
    public void test(){
        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> iFrameSayisi = driver.findElements(By.tagName("iframe"));
        System.out.println(iFrameSayisi.size());
        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement iFrame = driver.findElement(By.xpath("//*[@width='560']"));
        driver.switchTo().frame(iFrame);
        WebElement youtubeButon = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        youtubeButon.click();
        bekle(2);
        //4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke
        //(https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement ikinciiFrame = driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(ikinciiFrame);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        bekle(2);
    }
}
