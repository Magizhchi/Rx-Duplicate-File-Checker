import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by karth on 3/2/2017.
 */
public class Duplicator {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        List<File> allFilesInDir = fileUtil.getAllFilesRecursively("C:\\UH\\Cloud\\HW1\\CloudHW_1_Sparks");
        allFilesInDir.forEach(e -> System.out.println(e.getName()));

    }
}
