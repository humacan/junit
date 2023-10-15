package ders_grup;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
public class ders02 {
    @Test
    public void test01(){
        //  1-Bir test class’i olusturun ilgili ayarlari yapin
        //System.setProperty("Webdriver.chrome.driver","C:\\Users\\Uğur\\IdeaProjects\\Team120_Junit_Fall2023\\src\\test\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // 2-https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        // 3-Category bolumundeki elementleri locate edin
        WebElement categoryElement = driver.findElement(By.xpath("//div[@class='panel-group category-products']"));
        // 4-Category bolumunde 3 element oldugunu test edin
        List<WebElement> categoriList = driver.findElements(By.className("panel-title"));
        int expSayi=3;
        int actSay = categoriList.size();
        Assert.assertEquals(expSayi,actSay);
        // 5-Category isimlerini yazdirin
        for (WebElement each:categoriList
        ) {
            System.out.println(each.getText());
        }
        // 6-Sayfayi kapatin
        driver.close();
    }
}
