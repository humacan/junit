package day14_writeExcel_screenshot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_YoutubeArama extends TestBase {
    @Test
    public void youtubeAramaTesti(){
        driver.get("https://www.youtube.com");
        //cookies icin
        //driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[14]")).click();
        //ahmet bulutlu oz icin arama
        bekle(2);
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='search']"));

        aramakutusu.click();
        aramakutusu.sendKeys("Ahmet Bulutluoz"  + Keys.ENTER);
        bekle(2);
        WebElement ilkvideo=driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
        //bulunan video nun ilkinin isminde bulut gectigini test edin
        String expIcerik="QA";
        String actIcerik=ilkvideo.getText();
        Assert.assertTrue(actIcerik.contains(expIcerik));

        //ilk video isminin fotosunu cekin
        ReusableMethods.webElementFotografCek(ilkvideo,"Ahmet youtube");

        bekle(2);
        driver.close();
    }
}
