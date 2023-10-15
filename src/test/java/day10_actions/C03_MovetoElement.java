package day10_actions;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class C03_MovetoElement extends TestBase {
    @Test
    public void test01(){
    /*
    Bazi html kodlar mouse ile yaklastigimizda aktif hale gelir amazon anasayfadaki
    account&list menusu de mouse ile yaklasinca aciliyor

    maouse ile yaklasmasak da menu uzerindeki lniklere ait html kodlar gorunuyor ama
    kullanilamiyor

    acilir menuyu acmadan elementleri kullanmaya kalkisinca ElementNotInteractableException
    hatasi veriyor
     */

    //https://www.amazon.com
    driver.get("https://www.amazon.com");

    //sag ust bolumde bulunan "Account & List" menusunun acilmasi icin mause iu bu menunun ustune getirin
        Actions actions=new Actions(driver);
        WebElement Listelement=driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));

    actions.moveToElement(Listelement).perform();

    //"Create a list" butonuna basin

    driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    // Acilan sayfada "Your Lists" yazisi oldugunu test edin

    WebElement yourlistelemetn=driver.findElement(By.xpath("(//div[@role='heading'])"));

        Assert.assertTrue(yourlistelemetn.isDisplayed());

    }
}
