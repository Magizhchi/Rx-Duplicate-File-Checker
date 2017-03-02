import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by karth on 3/2/2017.
 */
public class FileUtil {
    private <T> Predicate<T> not(Predicate<T> predicate){
        return predicate.negate();
    }

    public List<String> getAllSubDirectoryPaths(String rootDir, List<String> subDirectories){
        File file = new File(rootDir);
        File[] files = file.listFiles();
        for (int i =0; i<files.length; i++){
            if ( files[i].isDirectory()){
                subDirectories.add(files[i].getAbsolutePath());
                getAllSubDirectoryPaths(files[i].getAbsolutePath(), subDirectories);
            }
        }
        return subDirectories;
    }

    public List<File> getAllFilesRecursively(String rootDir){
        FileUtil fileUtil = new FileUtil();
        return getAllSubDirectoryPaths(rootDir, new ArrayList<>()).stream()
                                                                  .flatMap(fileUtil::getAllFilesInDir)
                                                                  .collect(toList());
    }

    public Stream<File> getAllFilesInDir(String pathToDir){
        File file = new File(pathToDir);
        return Stream.of(file.listFiles())
                     .filter(File::isFile)
                     .filter(not(File::isHidden));
    }
}
