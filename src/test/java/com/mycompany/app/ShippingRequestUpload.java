package com.mycompany.app;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class ShippingRequestUpload
    extends TestCase
{

    public static class PageObject
    {
        public static String user_name = "ctl00$MainContent$ctlContent$lgUserLogin$UserName";
        public static String user_pass = "ctl00$MainContent$ctlContent$lgUserLogin$Password";
        public static String login_button = "LoginButton";
        public static String trans_broker = "html#ext-gen3.x-theme-blue.ext-strict body#ext-gen4.mainBody.ext-gecko.ext-gecko3 div.container form#form1 div div#BaseMainContent_Window1_Container div#BaseMainContent_Window1.x-panel.x-panel-noborder div#ext-gen14.x-panel-bwrap div#ext-gen15.x-panel-body.x-panel-body-noheader.x-panel-body-noborder.x-border-layout-ct div#BaseMainContent_pnlSettings.x-panel.lMenuPanel.x-panel-noborder.x-border-panel div#ext-gen20.x-panel-bwrap div#ext-gen21.x-panel-body.x-panel-body-noheader.x-panel-body-noborder div#BaseMainContent_Panel5.x-panel div#ext-gen30.x-panel-bwrap div#ext-gen31.x-panel-body.x-panel-body-noheader div#BaseMainContent_Panel5_Content div#BaseMainContent_UpdatePanel1 div#BaseMainContent_Panel6_Container div#BaseMainContent_Panel6.x-panel div#ext-gen53.x-panel-bwrap div#ext-gen54.x-panel-body.x-panel-body-noheader div#BaseMainContent_Panel8.x-panel.x-panel-noborder div#ext-gen59.x-panel-bwrap div#ext-gen60.x-panel-body.x-panel-body-noheader.x-panel-body-noborder div#BaseMainContent_Panel8_Content div#BaseMainContent_mnuNavigationTopMenu.menu ul.level1.static li.static a.level1.static";
        public static String company_requests = "BaseMainContent_treet0";
        public static String requests_frame = "ShippingRequestList_IFrame";
        public static String filter = "ext-gen178";
        public static String filter_clear = "ext-gen270";
        public static String filter_STO = "MainContent_ctlContent_ctl04_txtSTO";
        public static String filter_ok = "ext-gen268";
        public static String countRequests = "ext-comp-1107";
        public static String add_btn = "ext-gen162";
        public static String upload_frame = "wndDialog_IFrame";
        public static String upload_btn_first = "ext-gen163";
        public static String browse_file = "BaseMainContent_ucFileUoloadXls4Auction_uplUploader-file";
        public static String upload_btn = "ext-gen183";
        public static String save = "ext-gen49";

        public static String link = "http://iananova.loginet.ru/account/Login.aspx";
        public static String name = "test_cola";
        public static String pass = "542256test_cola";

        //public static String STO_cola = "291535";
        public static ShippingRequestValueContainerCola containerCola = ParserShippingRequestCola.parceToContainer();
        public static String file_path = containerCola.getFile_path();
    }
    public static class Cola
    {
        static String req_name_col = "x-grid3-col-RequestName";
        static String req_STO_col = ".x-grid3-col-STO";
        static String req_date_load_col = ".x-grid3-col-RequestDate";
        static String req_load_time_col = ".x-grid3-col-RequestTime";
        /*static String req_store_to_load_col = ".x-grid3-col-RequestDate";
        static String req_date_unload_col = ".x-grid3-col-RequestDate";
        static String req_time_unload_col = ".x-grid3-col-RequestDate";
        static String req_store_unload_col = ".x-grid3-col-RequestDate";*/
        static String req_service_type_col = ".x-grid3-col-RequestService";
        static String req_vehicle_type_col = ".x-grid3-col-RequestVehicleType";
        //static String req_body_space_col = ".x-grid3-col-RequestDate";
        //static String req_load_col = ".x-grid3-col-RequestDate";
        //static String req_weight_col = ".x-grid3-col-RequestDate";
        //static String req_trip_types_col = ".x-grid3-col-RequestDate";
        //static String req_region_col = ".x-grid3-col-RequestDate";
        static String req_comment_col = ".x-grid3-col-Comment";
        static String req_cost_col = ".x-grid3-col-RequestTotalCargoCost";
        static String req_price_col = ".x-grid3-col-RequestDesiredTransportationPrice";
    }
    public void LogIn()
    {
        $(By.name(PageObject.user_name)).setValue(PageObject.name);
        $(By.name(PageObject.user_pass)).setValue(PageObject.pass);
        $(By.id(PageObject.login_button)).click();
    }
    public void OpenTransBroker()
    {
        $(By.cssSelector(PageObject.trans_broker)).should(appear);
        $(By.cssSelector(PageObject.trans_broker)).click();
    }
    public void OpenRequests()
    {
        $(By.id(PageObject.company_requests)).should(appear);
        $(By.id(PageObject.company_requests)).click();
        // Switching to requests frame
        switchTo().frame(PageObject.requests_frame);

    }
    public void ClearFilter()
    {
        $(By.id(PageObject.filter)).waitUntil(present, 30000);
        $(By.id(PageObject.filter)).click();
        $(By.id(PageObject.filter_clear)).click();
        // Wait for requests to appear
        $(By.id(PageObject.countRequests)).waitUntil(matchText("Отображаются записи с 1 по 100"), 10000);
    }
    public void UploadRequests()
    {
        // First, lets click on "Добавить"
        $(By.id(PageObject.add_btn)).click();
        // Second, click on "Загрузка заявок"
        $(By.partialLinkText("Загрузка заявок")).click();
        // Third, wait for frame and switch to it
        $(By.name(PageObject.upload_frame)).waitUntil(present, 30000);
        // Switching to upload frame
        switchTo().frame(PageObject.upload_frame);
        // Fourth, click on "Загрузить"
        $(By.id(PageObject.upload_btn_first)).click();
        // Fifth, make your file with request(s) in it (or not (yor are a master here)) ready
        File ShippingRequestTemplate = new File(PageObject.file_path);
        // Sixth, upload your file, "master"
        $(By.name(PageObject.browse_file)).uploadFile(ShippingRequestTemplate);
        $(By.id(PageObject.upload_btn)).waitUntil(enabled, 30000);
        sleep(3000);
        $(By.id(PageObject.upload_btn)).click();
        // And then, u will need to save your brand new request(s) by clicking "Сохранить"

        $(By.id(PageObject.save)).click();
        switchTo().parentFrame();
        $(By.cssSelector(".x-grid3-col-RequestName")).waitUntil(present, 10000);
    }
    public void SetSTOFilter()
    {

        $(By.id(PageObject.filter)).click();
        $(By.id(PageObject.filter_STO)).waitUntil(visible, 30000);
        $(By.id(PageObject.filter_STO)).setValue(PageObject.containerCola.getSto());
        $(By.id(PageObject.filter_ok)).click();
        $(By.id(PageObject.countRequests)).waitUntil(text("Отображаются записи с 1 по 1, всего 1"), 10000);
    }
    public void SetGrid()
    {
        ElementsCollection Checkboxes = $$(By.xpath("//input[@class='x-menu-list-item']"));
        for (SelenideElement Iterator : Checkboxes)
            Iterator.setSelected(true);


    }
    public void verifyDataCola()
    {
        //sleep(4000);
        $(By.cssSelector(Cola.req_name_col)).waitUntil(present, 10000);
        $(By.cssSelector(Cola.req_STO_col)).shouldHave(text(PageObject.containerCola.getSto()));
        $(By.cssSelector(Cola.req_date_load_col)).shouldHave(text(PageObject.containerCola.getDateLoad()));
        $(By.cssSelector(Cola.req_load_time_col)).shouldHave(text(PageObject.containerCola.getTimeLoad()));
        /*$(By.cssSelector(Cola.req_store_to_load_col)).shouldHave(text(PageObject.containerCola.getStoreToLoad()));
        $(By.cssSelector(Cola.req_date_unload_col)).shouldHave(text(PageObject.containerCola.getDateUnload()));
        $(By.cssSelector(Cola.req_time_unload_col)).shouldHave(text(PageObject.containerCola.getTimeUnload()));
        $(By.cssSelector(Cola.req_store_unload_col)).shouldHave(text(PageObject.containerCola.getStoreUnload()));*/
        $(By.cssSelector(Cola.req_service_type_col)).shouldHave(text(PageObject.containerCola.getServiceType()));
        $(By.cssSelector(Cola.req_vehicle_type_col)).shouldHave(text(PageObject.containerCola.getVehicleType()));
        /*$(By.cssSelector(Cola.req_body_space_col)).shouldHave(text(PageObject.containerCola.getBodySpace()));
        $(By.cssSelector(Cola.req_load_col)).shouldHave(text(PageObject.containerCola.getLoad()));
        $(By.cssSelector(Cola.req_weight_col)).shouldHave(text(PageObject.containerCola.getWeight()));
        $(By.cssSelector(Cola.req_trip_types_col)).shouldHave(text(PageObject.containerCola.getTripTypes()));
        $(By.cssSelector(Cola.req_region_col)).shouldHave(text(PageObject.containerCola.getRegion()));*/
        $(By.cssSelector(Cola.req_comment_col)).shouldHave(text(PageObject.containerCola.getComment()));
        $(By.cssSelector(Cola.req_cost_col)).shouldHave(text(PageObject.containerCola.getCost()));
        $(By.cssSelector(Cola.req_price_col)).shouldHave(text(PageObject.containerCola.getPrice()));
    }

    @Test
    public void ShippingRequestUploadTest() throws IOException {
        // Opening LogIn link. Loading WebDriver and other boring stuff
        open(PageObject.link);
        // And now... Let's log in.
        LogIn();
        // Check grid "Транспортный брокер" and click on it then appear
        OpenTransBroker();
        // Check grid "Собственные заявки" and click on it then appear
        OpenRequests();
        // Clearing filter
        ClearFilter();
        // Lets move on. Going to upload some requests now
        UploadRequests();
        // Finally, set the filter to load only your request(s)
        SetSTOFilter();
        if (PageObject.user_name.equals("test_cola"))
            verifyDataCola();
        //SetGrid();
        //sleep(15000);
        //close();

    }
}
