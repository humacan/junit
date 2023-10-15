package day08_drowdownMenu_iframe;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
public class C03_JSalert extends TestBase {
    @Test
    public void test01(){

        driver.get("http://www.youtube.com");
        //cookies icin
        //driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill')[16]"));
        bekle(3);
    }
    @Test
    public void jsAlertTesti(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //Alert yazisinin "I am a JS Alert" oldugunu test edin
    driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
    bekle(2);
    String expYazi="I am a JS Alert";
    String actYazi=driver.switchTo().alert().getText();

        Assert.assertEquals(expYazi,actYazi);
    driver.switchTo().alert().accept();
    bekle(2);
    }
    @Test
    public void cancelTesti(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(2);
        //2. alert e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        bekle(2);
        //cancel a basip cikan sonuc yazisinin "You clicked: cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        bekle(2);
        String expSonuc="You clicked: Cancel";
        WebElement sonucYaziElement=driver.findElement(By.xpath("//*[@id='result']"));
        String actSonuc=sonucYaziElement.getText();
        Assert.assertEquals(expSonuc,actSonuc);
    }
    @Test
    public void prompTesti(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //3. alerte tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        //cikan prompt ekranina "Haydar" yazalim
        driver.switchTo().alert().sendKeys("Haydar");
        // OK tusuna basarak alerti kapatalim
        driver.switchTo().alert().accept();
        // cikan sonuc yazisinin 'Haydar' oldugunu test edlim
        WebElement sonucYazi=driver.findElement(By.xpath("//*[@id='result']"));
        String actSonuc=sonucYazi.getText();
        String expIcerik="Haydar";
        Assert.assertTrue(actSonuc.contains(expIcerik));
    }

}
