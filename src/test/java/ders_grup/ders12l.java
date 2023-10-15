package ders_grup;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import java.util.List;

public class ders12l extends TestBase {
    @Test
    public void test01(){
//1- Bir test class’i olusturun ilgili ayarlari yapin

//2- https://www.automationexercise.com/ adresine gidin
    driver.get("https://www.automationexercise.com");
//3- Category bolumundeki elementleri locate edin
    WebElement kategori= driver.findElement(By.xpath("//div[@class='panel-group category-products']"));

//4- Category bolumunde 3 element oldugunu test edin
        List<WebElement> kategorilist=driver.findElements(By.className("panel-title"));

        int expsayi=3;
        int actsayi=kategorilist.size();

        Assert.assertEquals(actsayi,expsayi);

//5- Category isimlerini yazdirin
        for (WebElement each : kategorilist) {
            System.out.println(each);
        }
//6- Sayfayi kapatin
        driver.close();
    }
}
