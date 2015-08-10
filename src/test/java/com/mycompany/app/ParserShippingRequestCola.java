package com.mycompany.app;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.FileInputStream;
import java.io.IOException;

public class ParserShippingRequestCola {
    public static int start = 2;                     //   line to sta
    public static int clmnsto = 1;                   //   B
    public static int clmndateLoad = 3;              //   D
    public static int clmntimeLoad = 4;              //   E
    public static int clmnstoreToLoad = 5;           //   F
    public static int clmndateUnload = 6;            //   G
    public static int clmntimeUnload = 7;            //   F
    public static int clmnstoreUnload = 8;           //   I
    public static int clmnserviceType = 9;           //   J
    public static int clmnvehicleType = 10;           //   K
    public static int clmnbodySpace = 11;             //   L
    public static int clmnload = 12;                  //   M
    public static int clmnweight = 13;                //   N
    public static int clmntripTypes = 14;             //   O
    public static int clmnregion = 15;                //   P
    public static int clmncost = 16;                  //   R
    public static int clmncomment = 17;               //   S
    public static int clmnprice = 18;                 //   T

    public static ShippingRequestValueContainerCola parceToContainer() {

        try{
            ShippingRequestValueContainerCola containerCola = new ShippingRequestValueContainerCola();
            POIFSFileSystem fs      =
                    new POIFSFileSystem(new FileInputStream(containerCola.getFile_path()));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            Sheet sheet1 = wb.getSheetAt(0);
            Row row1 = sheet1.getRow(start);

            containerCola.setSto(row1.getCell(clmnsto).getRichStringCellValue().getString());
            System.out.println(containerCola.getSto());//to detect parsing error
            containerCola.setDateLoad(row1.getCell(clmndateLoad).getRichStringCellValue().getString());
            System.out.println(containerCola.getDateLoad());
            containerCola.setTimeLoad(row1.getCell(clmntimeLoad).getRichStringCellValue().getString());
            System.out.println(containerCola.getTimeLoad());
            containerCola.setStoreToLoad(row1.getCell(clmnstoreToLoad).getRichStringCellValue().getString());
            System.out.println(containerCola.getStoreToLoad());
            containerCola.setDateUnload(row1.getCell(clmndateUnload).getRichStringCellValue().getString());
            System.out.println(containerCola.getDateLoad());
            containerCola.setTimeUnload(row1.getCell(clmntimeUnload).getRichStringCellValue().getString());
            System.out.println(containerCola.getTimeUnload());
            containerCola.setStoreUnload(row1.getCell(clmnstoreUnload).getRichStringCellValue().getString());
            System.out.println(containerCola.getStoreUnload());
            containerCola.setServiceType(row1.getCell(clmnserviceType).getRichStringCellValue().getString());
            System.out.println(containerCola.getServiceType());
            containerCola.setVehicleType(row1.getCell(clmnvehicleType).getRichStringCellValue().getString());
            System.out.println(containerCola.getVehicleType());
            containerCola.setBodySpace(row1.getCell(clmnbodySpace).getRichStringCellValue().getString());
            System.out.println(containerCola.getBodySpace());
            containerCola.setLoad(row1.getCell(clmnload).getRichStringCellValue().getString());
            System.out.println(containerCola.getLoad());
            containerCola.setWeight(row1.getCell(clmnweight).getRichStringCellValue().getString());
            System.out.println(containerCola.getWeight());
            containerCola.setTripTypes(row1.getCell(clmntripTypes).getRichStringCellValue().getString());
            System.out.println(containerCola.getTripTypes());
            containerCola.setRegion(row1.getCell(clmnregion).getRichStringCellValue().getString());
            System.out.println(containerCola.getRegion());
            containerCola.setCost(row1.getCell(clmncost).getRichStringCellValue().getString());
            System.out.println(containerCola.getCost());
            containerCola.setComment(row1.getCell(clmncomment).getRichStringCellValue().getString());
            System.out.println(containerCola.getComment());
            containerCola.setPrice(row1.getCell(clmnprice).getRichStringCellValue().getString());
            System.out.println(containerCola.getPrice());
            return containerCola;}
            catch (Exception e){
            System.out.println("Parsing error");
            return new ShippingRequestValueContainerCola();
        }

    }





}
