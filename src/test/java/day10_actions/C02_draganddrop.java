package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import utilities.TestBase;

    public class C02_draganddrop extends TestBase {
    @Test
    public void test01(){
    //https://demoqa.com/droppable adresine gidellim
    // "Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
    //"Drop here" yazisi yerine "Dropped!" oldugunu test edin

    driver.get("https://demoqa.com/droppable ");
        WebElement surukle=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement suruklenecek=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(surukle,suruklenecek).perform();

        String expYazi="Dropped!";
        String actYazi=driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

        Assert.assertEquals(expYazi,actYazi);

    }
}
