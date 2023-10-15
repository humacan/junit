package day10_actions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C04_Keyboardactions extends TestBase {
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        //arama kutusuna actons metdlari kullanarak
        //Samsung A71 yazdirin ve Enter a basarak arama yapin
        WebElement arama=driver.findElement(By.id("twotabsearchtextbox"));

        Actions actions=new Actions(driver);
        actions.click(arama)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyUp(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();


        //aramasnin gerceklestigini test edin
        String expIerik="Samsung A71";
        String actualSonucYazisi = driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"))
                .getText();
        Assert.assertTrue(actualSonucYazisi.contains(expIerik));

        bekle(3);
    }
}
