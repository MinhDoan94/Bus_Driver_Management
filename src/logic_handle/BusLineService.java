package logic_handle;

import entity.BusLine;
import entity.Driver;
import main.MainRun;
import util.fileUtil;

import java.util.Scanner;

public class BusLineService {
    public static final String BUS_LINE_FILE_NAME = "bus_line.dat";
    public static boolean isEmptyBusLine(){
    return MainRun.BUSLINES.isEmpty();
    }
    public static void creatNewBusLine() {
        System.out.println(" Bạn muốn nhập thêm mấy tuyến xe mới");
        int newBusLineNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newBusLineNumber; i++) {
            BusLine busLine = new BusLine();
            busLine.inputNewBusLine();
            MainRun.BUSLINES.add(busLine);
        }

        fileUtil.writeDataToFile(MainRun.BUSLINES, BUS_LINE_FILE_NAME);
    }

    public static void showBusLine() {
        MainRun.BUSLINES.forEach(System.out::println);
    }
    public static BusLine findById(int busLineId) {
        return MainRun.BUSLINES
                .stream()
                .filter(driver -> driver.getId() == busLineId)
                .findFirst()
                .orElse(null);
    }
}
