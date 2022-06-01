package logic_handle;

import entity.Driver;
import main.MainRun;
import util.fileUtil;

import java.util.Scanner;

public class DriverService {
    public static final String DRIVER_FILE_NAME = "driver.dat";
    public static boolean isEmptyDriver(){
        return MainRun.DRIVERS.isEmpty();
    }
    public static void showDriver() {
        MainRun.DRIVERS.forEach(System.out::println);
    }

    public static void creatNewDriver() {
        System.out.println(" Bạn muốn nhập thêm mấy lái xe mới");
        int newDriverNumber = new Scanner(System.in).nextInt();
        for (int i = 0; i < newDriverNumber; i++) {
            Driver driver = new Driver();
            driver.inputNewDriver();
            MainRun.DRIVERS.add(driver);
        }

        fileUtil.writeDataToFile(MainRun.DRIVERS, DRIVER_FILE_NAME);
    }
    public static Driver findById(int id) {
        return MainRun.DRIVERS
                .stream()
                .filter(driver -> driver.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
