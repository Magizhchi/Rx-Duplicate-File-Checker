import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by karth on 3/1/2017.
 */
public class MD5Util {

    public String getMD5ForFile(File file) throws IOException {
        HashCode hashCode = Files.hash(file, Hashing.md5());
        return hashCode.toString();
    }
}
