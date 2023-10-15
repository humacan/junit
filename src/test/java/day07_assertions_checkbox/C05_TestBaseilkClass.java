package day07_assertions_checkbox;

import org.junit.Test;
import utilities.TestBase;

public class C05_TestBaseilkClass extends TestBase {
    // onceki class larda setup ayarlamlarini Testbase den
    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        bekle(3);
    }

}
