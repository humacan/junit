package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReusableMethods {
    public static void bekle(int saniye){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public static void tumSayfaFotoCek(WebDriver driver,String resimadi){
        //her screenshot in benzersiz bir isme sahip olmasi icin
        //method un cagrildigi yerden resmi adi yollanacak
        //sonuna tarih etiketi ekleyelim 2310062013
        LocalDateTime ldt=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi=ldt.format(formatter);
        String dinamikDosyayolu="target/screenShots/"+resimadi+tarihEtiketi+".jpg";

        TakesScreenshot tss= (TakesScreenshot) driver;//tss objesi olusturduk
        File tumSayfaSS=new File( dinamikDosyayolu); //kaydedecegimiz yeri hazirladik

        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public static void webElementFotografCek(WebElement webElement, String resimAdi){
        // her screenshot'in benzersiz bir isme sahip olmasi icin
        // 1- method'un cagrildigi yerden resim adi yollanacak
        // 2- sonuna tarih etiketi ekleyelim 2310062013
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String tarihEtiketi = ldt.format(formatter);
        // target/screenShots/tumSayfaScreenshot.jpg
        String dinamikDosyaYolu = "target/screenShots/" + resimAdi + tarihEtiketi + ".jpg";
        File tumSayfaSS = new File(dinamikDosyaYolu); // kaydedecegimiz yeri hazirladik
        File geciciDosya = webElement.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaSS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
