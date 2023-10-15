package ders_grup;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ders03 extends TestBase {
    @Test
    public void test(){
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        //2- https://www.amazon.com adresine gidin
        driver.get("https://amazon.com");
        //3- amazon arama kutusunu locate edin
        WebElement textBox = driver.findElement(By.id("twotabsearchtextbox"));
        //4- arama kutusuna “Nutella” yazdirin
        textBox.sendKeys("Nutella" /*+ Keys.ENTER*/);
        //5- arama islemini yapabilmek icin ENTER tusuna basin
        textBox.submit();
    }
}
