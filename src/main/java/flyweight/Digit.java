package flyweight;

import java.io.*;
import java.util.*;

public class Digit {

    private static int callCount = 0;
    private List<String> data = new ArrayList<>();

    // 테스트용
    public static void resetCallCount() {
        callCount = 0;
    }

    public static int getCallCount() {
        return callCount;
    }

    public Digit(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            for (int i = 0; i < 5; ++i) {
                data.add(br.readLine());
            }
            ++callCount;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeReaders(fr, br);
        }
    }

    public void print() {
        for (String line: data) {
            System.out.println(line);
        }
    }

    private static void closeReaders(FileReader fr, BufferedReader br) {
        try {
            if (fr != null) {
                fr.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
