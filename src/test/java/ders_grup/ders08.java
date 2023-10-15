package ders_grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ders08 extends TestBase {
    @Test
    public void test(){
        //1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //2. Username kutusuna “standard_user” yazdirin
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        //3. Password kutusuna “secret_sauce” yazdirin
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        //4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();
        //driver.switchTo().alert().accept();
        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrun = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        String ilkUrunİsmi = ilkUrun.getText();
        System.out.println(ilkUrunİsmi);
        ilkUrun.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement sonucYazi = driver.findElement(By.xpath("//div[@class='cart_item_label']"));
        Assert.assertTrue(sonucYazi.getText().contains(ilkUrunİsmi));
        //9. Sayfayi kapatin
        driver.close();
    }
}
