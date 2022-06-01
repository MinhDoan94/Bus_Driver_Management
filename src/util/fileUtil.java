package util;

import java.io.*;
import java.util.List;

public class fileUtil {
    public static <T> List<T> readDataFromFile(String fileName) {
        if (fileName == null || fileName.trim().equals("")) {
            return null;
        }
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
            return (List) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }

    public static <T> void writeDataToFile(List<T> data, String fileName) {
        if (fileName == null || fileName.trim().equals("") || data == null || data.isEmpty()) {
            return;
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
            objectOutputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
