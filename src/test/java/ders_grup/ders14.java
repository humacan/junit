package ders_grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class ders14 extends TestBase {

    @Test
    public void test(){
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(driver);
        WebElement dragMe = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe,dropHere).perform();//dragAndDrop bize istenilen elementi istenilen alana sürükleyebilmemizi sağlıyor.
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedDroppedyazi = "Dropped!";
        String actualDroppedYazi = driver.findElement(By.xpath("//*[@class='drop-box ui-droppable ui-state-highlight']")).getText();
        Assert.assertEquals(expectedDroppedyazi,actualDroppedYazi);
        bekle(3);
    }
}
