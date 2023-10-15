package ders_grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ders05 {
    @Test
public void test(){
    //1- Bir test class’i olusturun ilgili ayarlari yapin
    //2- https://www.automationexercise.com/ adresine gidin
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("https://www.automationexercise.com/");
    //3- Sayfada 147 adet link bulundugunu test edin.
    int expectedLinkSayisi = 147;
    List<WebElement> linksayisi = webDriver.findElements(By.tagName("a"));
    System.out.println(linksayisi.size());
    Assert.assertTrue(expectedLinkSayisi==linksayisi.size());
    //4- Products linkine tiklayin
    webDriver.findElement(By.partialLinkText(" Products")).click();
    //5- special offer yazisinin gorundugunu test edin
    WebElement specialOffer = webDriver.findElement(By.id("sale_image"));
    if (specialOffer.isDisplayed()){
        System.out.println("Special offer testi passed");
    }else {
        System.out.println("Special offer testi failed");
    }
    //6- Sayfayi kapatin
    webDriver.close();
}
}
