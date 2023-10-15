package day11_fileTestleri;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileDownload extends TestBase {
        @Test
        public void test01(){
            //"C:\Users\dcsek\OneDrive\Desktop\logo.jpg"
//            1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
//            2. https://the-internet.herokuapp.com/download adresine gidelim.
            driver.get("https://the-internet.herokuapp.com/download");
//            3. logo.png dosyasını indirelim
            bekle(2);
            driver.findElement(By.xpath("//a[text()='logo.jpg']")).click();

//            4. Dosyanın başarıyla indirilip indirilmediğini test edelim
            String dosyayolu="C:\\Users\\dcsek\\Downloads\\logo.jpg";

            Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));

           bekle(2);
        }

}
