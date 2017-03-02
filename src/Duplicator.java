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
        MD5Util md5Util = new MD5Util();
        List<File> allFilesInDir = fileUtil.getAllFilesRecursively("C:\\Pictures");

        long startTime = System.currentTimeMillis();
        List<String> md5List = allFilesInDir.parallelStream()
                                            .map(md5Util::getMD5ForFile)
                                            .collect(toList());
        System.out.println("Total time taken : "+ (System.currentTimeMillis() - startTime));
        System.out.println("For a total of " + md5List.size() + " objects");
    }
}
