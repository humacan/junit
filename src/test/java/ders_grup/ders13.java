package ders_grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class ders13 extends TestBase {
    @Test
    public void test(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        /*
        Actions class klavye ve mouse manuel yapabildiğimiz hareketleri yapmamıza imkan tanır.
         */
        Actions actions = new Actions(driver);//Önce Actions class'ımızdan objemizi oluşturup Constructor'ına bir driver vermemiz gerek.
        WebElement element = driver.findElement(By.id("hot-spot"));//Üzerinde işlem yapacagımız WebElement'i locate ediyoruz.
        ReusableMethods.bekle(1);
        actions.contextClick(element).perform();//contextClick bize WebElement üzerinde sag click yapmamızı saglıyor
        // actions ile başlattıgımız her kod satırını .perform() ile sonlandırmamız gerekiyor
        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        actions.release();

        bekle(2);
        String expectedAlertYazi = "You selected a context menu";
        String actualAlertYazi = driver.switchTo().alert().getText();//JS alert deki yazıyı driver.switchTo().alert() ile geçiş yaparak alabiliriz.
        Assert.assertEquals(expectedAlertYazi,actualAlertYazi);
        //5- Tamam diyerek alert’i kapatalim
        ReusableMethods.bekle(1);
        driver.switchTo().alert().accept();
        //6- Elemental Selenium linkine tiklayalim
        ReusableMethods.bekle(1);
        /* Elemental Selenium linkine tıkladıgımızda yeni bir tab açıldıgı için çoklu window ile çalışacagımızdan
        window handle değerlerini almamız gerekiyor
         */
        String ilkSayfaHandleDegeri = driver.getWindowHandle();// İlk sayfa ilkSayfaHandleDegeri
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        actions.click(elementalSelenium).perform();// Locate ettiğimiz WebElement'i actions ile tıklıyoruz
        ReusableMethods.bekle(1);
        String ikinciSayfaHandleDegeri = "";
        Set<String> handleSet = driver.getWindowHandles();//Açık olan tüm sayfaların windowHandle degerlerinin set'e alınması
        for (String each: handleSet) {
            if (!each.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri = each;
            }
        }
        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        ReusableMethods.bekle(1);
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        ReusableMethods.bekle(1);
        String expectedIcerik = "Make sure your code lands";
        String actualIcerik = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedIcerik,actualIcerik);
        /*
        Test boyunca açık kalan sağ click menüsünü kapatamadım bir türlü!!! :)
         */
    }
}
