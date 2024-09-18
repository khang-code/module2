import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileExample {
    public void ReadFileText(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Tổng " + sum);
        } catch (Exception e) {
            System.err.println("File không tồn tại hoặc nội dung có lỗi");
        }
    }
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        ReadFileExample readFileEx = new ReadFileExample();
        readFileEx.ReadFileText(path);
    }
}