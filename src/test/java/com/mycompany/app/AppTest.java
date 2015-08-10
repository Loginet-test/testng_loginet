package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        open("http://iananova.loginet.ru/account/Login.aspx");
        $(By.name("ctl00$MainContent$ctlContent$lgUserLogin$UserName")).setValue("test_cola");
        $(By.name("ctl00$MainContent$ctlContent$lgUserLogin$Password")).setValue("542256test_cola");
        $(By.id("LoginButton")).click();
        $(By.xpath("/html/body/div[1]/form/div[3]/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div/span/a")).should(appear);     //проверяем, что Транспортный брокер доступен и жмякаем
        $(By.xpath("/html/body/div[1]/form/div[3]/div[1]/div/div/div/div[1]/div/div/div/div[1]/div[1]/div/span/a")).click();
        $(By.id("BaseMainContent_HeaderControl1_HeadLoginView_HeadLoginName")).shouldHave(text("test_cola"));
        $(By.xpath("/html/body/div[1]/form/div[3]/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[1]/ul/li[1]/a")).shouldHave(text("Транспортный брокер"));
        $(By.xpath("/html/body/div[1]/form/div[3]/div[1]/div/div/div/div[2]/div/div/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div/div/div[1]/ul/li[1]/a")).click();
        $(By.id("BaseMainContent_treet0")).should(appear);
        $(By.id("BaseMainContent_treet0")).click();
        switchTo().frame("ShippingRequestList_IFrame");
        //$(By.id("ext-gen162")).shouldHave(text("Добавить"));
        //$(By.id("ext-gen162")).click();
        //$(By.id("ext-gen267")).shouldHave(text("Загрузка заявок"));
        //$(By.id("ext-gen267")).click();
        //$(By.partialLinkText("заявок")).click();
        $(By.id("ext-comp-1107")).waitUntil(not(text("Нет данных для отображения")), 30000);            //ждем, пока внизу страницы не изменится эта надпись в течение 30 сек
        //$(By.id("ext-comp-1107")).waitUntil(text("Отображаrdrherhddются записи с 1 по 100, всего 7512"),30000);
        //$(By.id("ext-gen178")).click();
        $(By.id("ext-gen162")).click();        //add

        $(By.partialLinkText("Загрузка заявок")).click();        //загрузка заявок
        //$(By.id("BaseMainContent_ucFileUoloadXls4Auction_uplUploader-file")).shouldBe(present);    //ждем появления фрейма
        sleep(3000);
        //$(By.name("wndDialog")).waitUntil(present,15000);

        switchTo().frame("wndDialog_IFrame");  //
        $(By.linkText("Шаблон загрузки")).click();
        sleep(10000);
        //$(By.linkText("Шаблон загрузки")).;
        //System.out.println(getFileName($(By.linkText("Шаблон загрузки"))));
        //$(By.linkText("Шаблон загрузки")).download();
        //FileDownloader nf = new FileDownloader();
        //nf.download($(By.linkText("Шаблон загрузки")));
        //System.out.println(getFileName(nf));
        //sleep(15000);
        //$(By.id("ext-gen163")).click();
        //switchTo().window("wndDialog_IFrame");
        //sleep(10000);
        ////switchTo().innerFrame();
        ////switchTo().window("BaseMainContent_ucFileUoloadXls4Auction_wndUploadFile");
        //File s = new File("C:\\Users\\supfe_000\\SkyDrive\\работа\\Образцы\\кола 15  заявка.xls")  ;
        //$(By.name("BaseMainContent_ucFileUoloadXls4Auction_uplUploader-file")).uploadFile(s);
        //sleep(5000);
    }
}
