package main;

import Constant.DriverLevel;
import entity.BusLine;
import entity.Driver;
import entity.DriverManagement;
import logic_handle.BusLineService;
import logic_handle.DriverManagementService;
import logic_handle.DriverService;
import util.DataUtil;
import util.fileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainRun {
    public static List<Driver> DRIVERS = new ArrayList<>();
    public static List<BusLine> BUSLINES = new ArrayList<>();
    public static List<DriverManagement> DRIVER_MANAGEMENTS = new ArrayList<>();

    public static void main(String[] args) {
        initData();
        menu();
    }

    private static void initData() {
        DRIVERS = fileUtil.readDataFromFile(DriverService.DRIVER_FILE_NAME);
        if (DataUtil.isEmptyCollection(DRIVERS)) {
            DRIVERS = new ArrayList<>();
        }

        BUSLINES =  fileUtil.readDataFromFile(BusLineService.BUS_LINE_FILE_NAME);
        if (DataUtil.isEmptyCollection(BUSLINES)) {
            BUSLINES = new ArrayList<>();
        }

        DRIVER_MANAGEMENTS =  fileUtil.readDataFromFile(DriverManagementService.DRIVER_MANAGEMENT_FILE_NAME);
        if (DataUtil.isEmptyCollection(DRIVER_MANAGEMENTS)) {
            DRIVER_MANAGEMENTS = new ArrayList<>();
        }
    }



    private static void menu() {
        do {
            int funtionChoice = showMenu();
            switch (funtionChoice) {

                case 1:
                    DriverService.creatNewDriver();
                    break;
                case 2:
                    DriverService.showDriver();
                    break;
                case 3:
                    BusLineService.creatNewBusLine();
                    break;
                case 4:
                    BusLineService.showBusLine();
                    break;
                case 5:
                    DriverManagementService.createDrivingSchedule();
                    break;
                case 6:
                    DriverManagementService.showData();
                    break;
                case 7:
                    DriverManagementService.sortByDriverName();
                    break;
                case 8:
                    DriverManagementService.calculateTotalRound();
                    break;
                case 9:
                    return;
            }
        } while (true);
    }


    private static int showMenu() {
        printMenu();
        int funtionChoice = -1;
        do {
            try {
                funtionChoice = new Scanner(System.in).nextInt();
            } catch (InputMismatchException ex) {
                System.out.println(" Ch???c n??ng c???n ch???n l?? m???t s??? nguy??n, h??y nh???p l???i");
            }
            if (funtionChoice >= 1 && funtionChoice <= 9) {
                break;
            }
            System.out.println("Ch???c n??ng v???a ch???n kh??ng h???p l???, vui l??ng ch???n l???i: ");
        } while (true);
        return funtionChoice;
    }

    private static void printMenu() {
        System.out.println("-----PH???N M???M QU???N L?? L??I XE BU??T------");
        System.out.println("1. Nh???p danh s??ch l??i xe m???i");
        System.out.println("2. In ra danh s??ch l??i xe m???i");
        System.out.println("3. Nh???p danh s??ch tuy???n xe m???i");
        System.out.println("4. In ra danh s??ch l??i xe m???i");
        System.out.println("5. Ph??n c??ng l??i xe cho t??i x??? m???i");
        System.out.println("6. In ra danh s??ch ???? ph??n c??ng");
        System.out.println("7. S???p x???p danh s??ch ph??n c??ng l??i xe m???i");
        System.out.println("8. B???ng th???ng k?? t???ng kho???ng c??ch ch???y xe trong ng??y c???a t???ng l??i xe");
        System.out.println("9. Tho??t ch????ng tr??nh");
        System.out.println(" Xin m???i ch???n ch???c n??ng: ");
    }
}
