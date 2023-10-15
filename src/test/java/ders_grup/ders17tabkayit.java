package ders_grup;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ders17tabkayit extends TestBase {
    @Test
    public void test01(){
//        1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
//        2- Cookies kabul edin

//        3- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        bekle(3);

//        4- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        Actions actions=new Actions(driver);
        WebElement kutu=driver.findElement(By.xpath("//*[@name='firstname']"));


        actions.click(kutu).sendKeys("dogu").sendKeys(Keys.TAB).sendKeys("can").sendKeys(Keys.TAB).sendKeys("55555555")
                .sendKeys(Keys.TAB).sendKeys("12345678").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
//        5- Kaydol tusuna basalim
        bekle(5);

    }
}
