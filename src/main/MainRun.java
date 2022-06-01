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
                System.out.println(" Chức năng cần chọn là một số nguyên, hãy nhập lại");
            }
            if (funtionChoice >= 1 && funtionChoice <= 9) {
                break;
            }
            System.out.println("Chức năng vừa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        return funtionChoice;
    }

    private static void printMenu() {
        System.out.println("-----PHẦN MỀM QUẢN LÝ LÁI XE BUÝT------");
        System.out.println("1. Nhập danh sách lái xe mới");
        System.out.println("2. In ra danh sách lái xe mới");
        System.out.println("3. Nhập danh sách tuyến xe mới");
        System.out.println("4. In ra danh sách lái xe mới");
        System.out.println("5. Phân công lái xe cho tài xế mới");
        System.out.println("6. In ra danh sách đã phân công");
        System.out.println("7. Sắp xếp danh sách phân công lái xe mới");
        System.out.println("8. Bảng thống kê tổng khoảng cách chạy xe trong ngày của từng lái xe");
        System.out.println("9. Thoát chương trình");
        System.out.println(" Xin mời chọn chức năng: ");
    }
}
