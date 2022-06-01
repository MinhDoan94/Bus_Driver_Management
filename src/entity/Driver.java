package entity;

import Constant.DriverLevel;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver extends Person implements AutoIdIncreasable, Serializable {
    private static int AUTO_ID = 10000;
    private int id;

    private DriverLevel level;

    public Driver() {
        this.increaseId();
    }

    public Driver( DriverLevel level) {
        this.level = level;
    }

    public Driver(String name, String address, String phone, DriverLevel level) {
        this.level = level;
        this.increaseId();
    }

    public final void increaseId() {
        this.id = AUTO_ID++;

    }

    public int getId() {
        return id;
    }


    public DriverLevel getLevel() {
        return level;
    }

    public void setLevel(DriverLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", level=" + level +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
    public void inputNewDriver(){
        System.out.print("Nhập tên của tài xế : ");
        this.setName(new Scanner(System.in).nextLine());
        System.out.print("Nhập địa chỉ của tài xế : ");
        this.setAddress(new Scanner(System.in).nextLine());
        System.out.print("Nhập số điện thoại của tài xế : ");
        this.setPhone(new Scanner(System.in).nextLine());
        System.out.println("Nhập trình độ của tài xế, chọn một trong các trình độ dưới đây : ");
        System.out.println("1. Loại A");
        System.out.println("2. Loại B");
        System.out.println("3. Loại C");
        System.out.println("4. Loại D");
        System.out.println("5. Loại E");
        System.out.println("6. Loại F");
        System.out.print("Chọn trình độ: ");
        int driverLevel = -1;
        do {
            try {
                driverLevel = new Scanner(System.in).nextInt();
            } catch (InputMismatchException ex) {
                System.out.println(" Chức năng cần chọn là một số nguyên, hãy nhập lại");
            }
            if (driverLevel >= 1 && driverLevel <= 6) {
                break;
            }
            System.out.println("Chức năng vừa chọn không hợp lệ, vui lòng chọn lại: ");
        } while (true);
        switch (driverLevel) {
            case 1:
                this.setLevel(DriverLevel.LEVEL_A);
                break;
            case 2:
                this.setLevel(DriverLevel.LEVEL_B);
                break;
            case 3:
                this.setLevel(DriverLevel.LEVEL_C);
                break;
            case 4:
                this.setLevel(DriverLevel.LEVEL_D);
                break;
            case 5:
                this.setLevel(DriverLevel.LEVEL_E);
                break;
            case 6:
                this.setLevel(DriverLevel.LEVEL_F);
                break;
        }
    }
}


