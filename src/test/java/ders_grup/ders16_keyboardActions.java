package ders_grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.sql.Driver;

public class ders16_keyboardActions extends TestBase {
    @Test
   public void test01(){
//        1- Bir Class olusturalim KeyboardActions1
//        2- https://www.amazon.com sayfasina gidelim
          driver.get("https://www.amazon.com");
//        3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin ve
        //        Enter’a basarak arama yaptirin
        WebElement kutu=driver.findElement(By.id("twotabsearchtextbox"));
        kutu.click();
        Actions actions=new Actions(driver);

        actions.click(kutu).keyDown(Keys.SHIFT).sendKeys("s").keyUp(Keys.SHIFT)
                .sendKeys("amsung ").keyDown(Keys.SHIFT).sendKeys("a").keyUp(Keys.SHIFT)
                .sendKeys("71").sendKeys(Keys.ENTER).perform();

//        4- aramanin gerceklestigini test edin
        WebElement yazi=driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));

        Assert.assertTrue(yazi.isDisplayed());

    }
}
