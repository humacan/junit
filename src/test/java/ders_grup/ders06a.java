package ders_grup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.util.List;

public class ders06a extends TestBase {
        @Test
        public void test01(){
//1. Yeni bir Class olusturalim.C07_ManageWindowSet
    WebDriver driver=new ChromeDriver();

//2. Amazon soyfasina gidelim. https://www.amazon.com/
            driver.get("htpps://www.amazon.com");

//3. Sayfanin konumunu ve boyutlarini yazdirin
            System.out.println(driver.manage().window().getSize());
            System.out.println(driver.manage().window().getPosition());


//4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
       driver.manage().window().setSize(new Dimension(600,500));
       driver.manage().window().setPosition(new Point(200,300));


//5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin

    //WebElement boy= (WebElement) driver.manage().window().getSize();
    //WebElement poz= (WebElement) driver.manage().window().getPosition();

    //Assert.assertTrue(boy.isDisplayed());
    //Assert.assertTrue(poz.isDisplayed());
//8. Sayfayi kapatin
    driver.close();
        }


}
