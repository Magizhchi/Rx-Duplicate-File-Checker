import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by karth on 3/3/2017.
 */
public class DuplicateProcessor {
    Set<String> fileHashes= new HashSet<>();

    void process(List<File> allFilesInDir) {
        allFilesInDir.parallelStream()
                     .forEach((file) -> addOrPrintDuplicates(file));
    }

    private void addOrPrintDuplicates(File file) {
        String hash = new MD5Util().getMD5ForFile(file);
        if(fileHashes.contains(hash)){
            System.out.println(file.getAbsolutePath() + " is a Duplicate");
        } else {
            fileHashes.add(hash);
        }
    }
}
