import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String []args) {
        // 定义CSV文件路径
        String csvFile1Path = "C:\\Users\\tjy\\Desktop\\fbs\\cleaned5.csv";
        String csvFile2Path = "C:\\Users\\tjy\\Desktop\\fbs\\cleaned6.csv";
        String csvFile3Path = "C:\\Users\\tjy\\Desktop\\fbs\\cleaned7.csv";
        String csvFile4Path = "C:\\Users\\tjy\\Desktop\\fbs\\cleaned8.csv";
        // 读取CSV文件并转换为字符串
        String s1 = readFileToString(csvFile1Path);
        String s2 = readFileToString(csvFile2Path);
        String s3 = readFileToString(csvFile3Path);
        String s4 = readFileToString(csvFile4Path);
        // 调用Statistic函数
        Analysis.Statistic(s1, s2,s3,s4);

    }

    /**
     * 读取文件内容并转换为字符串
     *
     * @param filePath 文件路径
     * @return 文件内容字符串
     */
    private static String readFileToString(String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
