package day10_actions;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C00_sample extends TestBase {
    @Test
    public void test01(){
//        Yeni Class olusturun ActionsClassHomeWork

//        1- "http://webdriveruniversity.com/Actions" sayfasina gidin
          driver.get("http://webdriveruniversity.com/Actions");
//        2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hover=driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        actions.moveToElement(hover).perform();

//        3- Link 1" e tiklayin
         driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

//        4- Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());


//        5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        bekle(2);


//        6- “Click and hold" kutusuna basili tutun
        WebElement clikhold=driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clikhold).perform();



//        7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@style='background: rgb(0, 255, 0); font-size: 30px;']")));

//        8- “Double click me" butonunu cift tiklayin
        driver.findElement(By.xpath("//*[@class='div-double-click']")).click();



    }
}
