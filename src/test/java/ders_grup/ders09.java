package ders_grup;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class ders09 extends TestBase {
    @Test
    public void test(){
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.id("signin_button")).click();
        //3. Login alanine “username” yazdirin
        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username");
        //4. Password alanina “password” yazdirin
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();
        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("100");
        bekle(1);
        //9. tarih kismina “2020-09-10” yazdirin
        WebElement date = driver.findElement(By.id("sp_date"));
        date.sendKeys("2020-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //11. “The payment was successfully submitted.”
        WebElement element = driver.findElement(By.id("alert_content"));
        Assert.assertTrue(element.getText().equals("The payment was successfully submitted."));
    }
}
