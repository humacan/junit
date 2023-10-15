package day11_fileTestleri;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
    public class C03_FileUpload extends TestBase {
    @Test
    public void test01(){
//        2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        bekle(1);

//        3. chooseFile butonuna basalim
//        4. text.txt dosyayi secelim.
        //dosya secim penceresine tiklamak yerine Selenium un bize
        // sundugu Webelement secenek ile istedigimiz dosyayi sendkeys ile sisteme yollariz
        WebElement choosefile=driver.findElement(By.id("file-upload"));
        String dinamikdosyayolu=System.getProperty("user.dir")+"\\src\\test\\java\\day11_fileTestleri\\text.txt";
        choosefile.sendKeys(dinamikdosyayolu);

//        5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

//        6. “File Uploaded!” textinin goruntulendigini test edelim

        WebElement fileuploadedelement=driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileuploadedelement.isDisplayed());


    }
}
