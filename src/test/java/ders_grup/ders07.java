package ders_grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ders07 extends TestBase {
    @Test
    public void test(){
        //1- C01_TekrarTesti isimli bir class olusturun
        //2- https://www.google.com/ adresine gidin
        driver.get("https://google.com");
        //3- cookies uyarisini kabul ederek kapatin
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucYazisi.getText());
        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        //Yaklaşık 166.000.000 sonuç bulundu
        String newSonuc = sonucYazisi.getText().substring(9,20).replaceAll("\\W","");
        //System.out.println(newSonuc);
        int intNewSonuc = Integer.parseInt(newSonuc);
        Assert.assertTrue(intNewSonuc>10000000);
        // Yaklaşık 151.000.000 sonuç bulundu
        //8- Sayfayi kapatin
    }
}
