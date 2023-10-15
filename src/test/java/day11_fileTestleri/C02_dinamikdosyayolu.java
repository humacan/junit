package day11_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_dinamikdosyayolu extends TestBase {
    @Test
    public void test(){
        //masaustunde bulunan logo.jpg dosyasini dinamik sekilde test edelim
        //"C:\Users\dcsek\Desktop"
    String dinamikdsyyolu=System.getProperty("User.home")+"\\dcsek\\Desktop\\logo.jpg";

        System.out.println(dinamikdsyyolu);

        //Assert.assertTrue(Files.exists(Path.of(dinamikdsyyolu)));

        System.out.println(System.getProperty("user.dir")); //C:\Users\dcsek\IdeaProjects\Team120_JUnit_Fall2023

        //text in pathi
        //C:\Users\dcsek\IdeaProjects\Team120_JUnit_Fall2023\src\test\java\day11_fileTestleri\text.txt
        String dinamikTexDosyayolu=System.getProperty("user.dir")+"\\src\\test\\java\\day11_fileTestleri\\text.txt";
        Assert.assertTrue(Files.exists(Paths.get(dinamikTexDosyayolu)));

    }
}
