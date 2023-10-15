package day09_iframe;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

    public class C00_sample extends TestBase {
        @Test
        public void test01() {
            // 1.   http://zero.webappsecurity.com/ Adresine gidin
            driver.get("http://zero.webappsecurity.com/");
            // 2.   Sign in butonuna basin
            driver.findElement(By.xpath("//button[@id='signin_button']")).click();
                                                          //xpath => id='signin_button'
            // 3.   Login kutusuna “username” yazin
            WebElement loginKutusu = driver.findElement(By.id("user_login"));
                                                             // =>user_login
            loginKutusu.sendKeys("username");
            // 4.  Password kutusuna “password” yazin
            WebElement passwordKutusu = driver.findElement(By.id("user_password"));
            passwordKutusu.sendKeys("password");
            // 5. Sign in tusuna basin, back tusuna basarak sayfaya donun
            driver.findElement(By.xpath("//input[@name='submit']")).click();

            driver.navigate().back();
            // 6. Online banking menusunden Pay Bills sayfasina gidin
            driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
            driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
            //7. “Purchase Foreign Currency” tusuna basin
            driver.findElement(By.xpath("//a[text()='Purchase Foreign Currency']")).click();
            //8. “Currency” drop down menusunden Eurozone’u secin
            WebElement dropDownElementi = driver.findElement(By.xpath("//select[@id='pc_currency']"));
            Select select = new Select(dropDownElementi);
            select.selectByVisibleText("Eurozone (euro)");
            //9. “amount” kutusuna bir sayi girin
            WebElement amountKutusu = driver.findElement(By.xpath("//input[@id='pc_amount']"));
            amountKutusu.sendKeys("100");
            //10. “US Dollars” in secilmedigini test edin
            WebElement usDollarRadioButton = driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
            Assert.assertFalse(usDollarRadioButton.isSelected());
            //11. “Selected currency” butonunu secin
            WebElement selectedCurrencyButonu = driver.findElement(By.xpath("//input[@id='pc_inDollars_false']"));
            selectedCurrencyButonu.click();
            //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
            driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
            driver.findElement(By.xpath("//input[@id='purchase_cash']")).click();
            //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
            String expectedYazi = "Foreign currency cash was successfully purchased.";
            String actualYaziElementi = driver.findElement(By.xpath("//div[text()='Foreign currency cash was successfully purchased.']")).getText();
            Assert.assertEquals(expectedYazi,actualYaziElementi);
}
    }