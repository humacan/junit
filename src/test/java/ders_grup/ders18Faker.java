package ders_grup;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class ders18Faker extends TestBase {
    @Test
    public void test01(){
        Faker faker=new Faker();
        Actions actions=new Actions(driver);
//1. "https://facebook.com" Adresine gidin
    driver.get("https://facebook.com");
//2. “create new account” butonuna basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
//3. “firstName” giris kutusuna bir isim yazin
        WebElement kutu=driver.findElement(By.xpath("//*[@name='firstname']"));
        String email=faker.internet().emailAddress(); // faker iki rastgele olusturdugu icin bir kere sabitlamis olduk
    actions.sendKeys(faker.name().firstName())
            .sendKeys(Keys.TAB)
            .sendKeys(faker.name().lastName())
            .sendKeys(Keys.TAB)
            .sendKeys(email)
            .sendKeys(Keys.TAB)
            .sendKeys(email)
            .sendKeys(Keys.TAB)
                    .sendKeys(faker.internet().password())
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
                    .sendKeys("5")
            .sendKeys(Keys.TAB)
                    .sendKeys("Ekim")
            .sendKeys(Keys.TAB)
                    .sendKeys("1999")
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.ARROW_RIGHT)
             .perform();

//4. “surname” giris kutusuna bir soyisim yazin

//5. “email” giris kutusuna bir email yazin
//6. “email” onay kutusuna emaili tekrar yazin
//7. Bir sifre girin
//8. Tarih icin gun secin
//9. Tarih icin ay secin
//10. Tarih icin yil secin
//11. Cinsiyeti secin
//12. Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement erkek=driver.findElement(By.xpath("//input[@value='2']"));
        Assert.assertTrue(erkek.isEnabled());

        WebElement kadin=driver.findElement(By.xpath("//input[@value='1']"));

       Assert.assertTrue(kadin.isEnabled());

//13. Sayfayi kapatin
        driver.close();
    }


}
