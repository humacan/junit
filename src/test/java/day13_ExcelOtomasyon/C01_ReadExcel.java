package day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {
    @Test
    public void readExcelTestleri() throws IOException {
        String dosyayolu="C:\\Users\\dcsek\\IdeaProjects\\Team120_JUnit_Fall2023\\src\\test\\java\\day13_ExcelOtomasyon\\ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyayolu);

        Workbook workbook= WorkbookFactory.create(fis);
        //olusturmus oldugumuz workbook, online olarak excel dosyasina erisemez
        //18.satirda fileInputStream kullanarak excel deki bilgileri aldik
        //20.satirda fis in aldigi bigileri kullanarak kodlarimizin icinde
        //fiziki excel dosyasinin bir kopyasini olusturmus olduk

        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(3);
        Cell cell=row.getCell(3);

        System.out.println(cell);
        //1.satir 2.hucreye gidelim ve yazdiralim
        System.out.println(sheet.getRow(0).getCell(1));
        //1.satir 2 hucreyi String bir degiskene atayalim
        String istenendata= String.valueOf(sheet.getRow(0).getCell(1));
        System.out.println(istenendata);
        //2.satir 4.cell in afganistan in baskenti oldugunu test edelim
        String expectedData="Kabil";
        String actData= String.valueOf(sheet.getRow(1).getCell(3));
        Assert.assertEquals(expectedData,actData);
        //satir sayisini bulalim
        System.out.println(sheet.getLastRowNum()+1);  //190 satirin index ini verir
                                                      //biz satir sayisini bulmak icin 1 ekledik
        //Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sheet.getPhysicalNumberOfRows());//direk fiziki olarak kullanilan satir sayisi
        //Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim
        String isim;
        String baskent;
        Map<String,String> ulkelerMap=new TreeMap<>();
        for (int i = 0; i <=sheet.getLastRowNum() ; i++) {
            isim=sheet.getRow(i).getCell(0).toString();
            baskent=sheet.getRow(i).getCell(1).toString();
            ulkelerMap.put(isim,baskent);

        }
        System.out.print(ulkelerMap);
        //ulkeler excel inde Canada isimli bir ulke oldugunu test edin
        Assert.assertTrue(ulkelerMap.containsKey("Canada"));

        //ulkeler excel inde Cuba nin baskentin Havan oldugunu test edin

        String expectedBaskent="Havana";
        String actBaskent=ulkelerMap.get("Cuba");
        Assert.assertEquals(expectedBaskent,actBaskent);

    }
}
