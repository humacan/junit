package ders_grup;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
import java.sql.Driver;

public class ders15_actionClass extends TestBase {
    @Test
 public void test01(){

 // 1- https://www.amazon.com/ adresine gidin
 driver.get("https://www.amazon.com");

//2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin
//    mouse’u bu menunun ustune getirin
 Actions actions=new Actions(driver);
 WebElement accountlist=driver.findElement(By.xpath("//span[@class='nav-line-2 ']" ));
  actions.moveToElement(accountlist).perform();

//3- “Create a list” butonuna basin
 driver.findElement(By.xpath("//span[text()='Create a List']")).click();
//4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
 String expIcerik="Your Lists";
 String actIcerik=driver.findElement(By.xpath("//*[@aria-level='1']")).getText();

  Assert.assertTrue(actIcerik.equals(expIcerik));
   }
}
