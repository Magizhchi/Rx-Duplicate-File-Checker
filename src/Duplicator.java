import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by karth on 3/2/2017.
 */
public class Duplicator {
    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();
        DuplicateProcessor duplicateProcessor = new DuplicateProcessor();

        List<File> allFilesInDir = fileUtil.getAllFilesRecursively("C:\\Pictures");

        long startTime = System.currentTimeMillis();
        duplicateProcessor.process(allFilesInDir);
        System.out.println("Total time taken : "+ (System.currentTimeMillis() - startTime));
        System.out.println("For a total of " + allFilesInDir.size() + " objects");
    }



}
