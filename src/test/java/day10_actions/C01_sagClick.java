package day10_actions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.util.Set;

public class C01_sagClick extends TestBase {
        @Test
        public void test01(){
        //https://the-internet.herokuapp.com/contex_menu/ sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        bekle(2);
        //cizili alan uzerinde sag click yapin
        WebElement cizilielement=driver.findElement(By.id("hot-spot"));
            Actions actions=new Actions(driver);
        actions.contextClick(cizilielement).perform();
        bekle(2);
        //Alert te cikan yazinin "You selected a context menu" oldugunu test edin
        String expAlertYazi="You selected a context menu";
        String actAlertyazi=driver.switchTo().alert().getText();
            Assert.assertEquals(expAlertYazi,actAlertyazi);
        //tamam diyerek alert i kapatalim
            driver.switchTo().alert().accept();
        // /Elemental Selenium Linkine tiklayalim
            //
        bekle(2);
            String ilksayfamwhd=driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        String ikincisayfawhd="";
            Set<String> whdseti=driver.getWindowHandles();
            for (String each:whdseti  ) {
                if (!each.equals(ilksayfamwhd)){
                    ikincisayfawhd=each;
                }
            }
        //Acilan sayfada h1 taginda "Make sure your code lands" yazisinin test edelim
            driver.switchTo().window(ikincisayfawhd);

            String expYazi="Make sure your code lands";
            String actYazi= driver.findElement(By.tagName("h1")).getText();

            Assert.assertEquals(expYazi,actYazi);
        bekle(2);
        }
}
