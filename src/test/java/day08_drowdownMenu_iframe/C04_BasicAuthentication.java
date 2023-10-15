package day08_drowdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_BasicAuthentication extends TestBase {
   @Test
    public void test01(){
       //https://the-internet.herokuapp.com/basic_auth
       //asagidaki yontem ve test daatalrini kullanarak authencation yapin
       //html komutu: https://username:passsword@URL
       //usarname : admin
       //password : admin
       driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
       // Basarili sekilde sayfaya girildigini dogrulayain

       String expIcerik="Congratulations";
       WebElement tebrikYazielement=driver.findElement(By.tagName("p"));
       String actTebrikyazi=tebrikYazielement.getText();

       Assert.assertTrue(actTebrikyazi.contains(expIcerik));
       bekle(2);
   }


}
