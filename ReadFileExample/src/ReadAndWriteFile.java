import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filepath) {
        List<Integer> numbers = new ArrayList<>();
    try {
        File file = new File(filepath);
    if (!file.exists());
        throw new FileNotFoundException();
    }
    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
    String line = "";
    while ((line= bufferedReader.readLine())!=null){
        numbers.add(Integer.parseInt((line)));
    }
        bufferedReader.close();
    } catch (Exception e) {
        System.out.println("File không tồn tại hoặc nội dung bị lỗi");
    }
    reuturn numbers;
}