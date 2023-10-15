package day05_JUnitFramework;
import org.junit.Ignore;
import org.junit.Test;
public class C02_TestNotasyonu {
    //@Test notasyonu siradan methodlari main method olmadan class level dan toplu calistirmamiza imkan tanir
    //ayrica ilerde gorecegimiz sekilde test methodlarini belirli gruplara dahil edip toplu olarak da calistirabiliriz
    //@Test notasyonuna sahip methodlar toplu olarak calistirildiginda hangi sira ile calicagina dair bir kural yoktur
    //calisma sirasi ONGORULEMEZ

    /*          Eger bir test method'u @ignore olarak isaretlenirse
        Selenium o method'u ignore eder
        calistirmaz
        JUnit bize calisan testlerden
        kacinin PASSED, kacinin FAILED oldugunu verir
        ANCAK JUnit testlerin gecip gecmedigini
        kodlarda bir sorun yasanip yasanmamasina baglar
        kodlar sorunsuz calisirsa, Test PASSED
        bir exception olusursa, Test FAILED
        olarak kaydedilir */
    @Test
    public void amazonTest(){
        System.out.println("amazon Test Calisti");
    }
    @Test @Ignore
    public void youtubeTest(){
        System.out.println("youtube Test Calisti");

    }
    @Test
    public void wiseTest(){
        System.out.println("wise Test Calisti");
    }
    @Test
    public void Test04(){
        int sayi1=10;
        int sayi2=20;

        if (sayi1>sayi2){
            System.out.println("Karsilastirma testi PASSED");
        }else {
            System.out.println("Karsilastirma testi FAILED");
            throw new IllegalArgumentException();
        }
    }
}
