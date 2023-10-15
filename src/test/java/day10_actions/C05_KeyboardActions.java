package day10_actions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01(){
        //https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        // cookies kabul edin

        // Yeni hesap olustur butonuna basalim
         driver.findElement(By.xpath("//*[@*='open-registration-form-button']")).click();

         WebElement isimkutu=driver.findElement(By.name("firstname"));

         Actions actions=new Actions(driver);

         Faker faker=new Faker();
         String email=faker.internet().emailAddress();

         actions.click(isimkutu)
                 .sendKeys(faker.name().firstName())
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
                 .sendKeys("Mart")
                 .sendKeys(Keys.TAB)
                 .sendKeys("2000")
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.TAB)
                 .sendKeys(Keys.ARROW_RIGHT)
                 .perform();


        // kaydol tusuna basalim
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        bekle(2);

    }
}
