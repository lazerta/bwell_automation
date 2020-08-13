package generic;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathUtil {
    public static String join(String base,String ... paths){
        return Paths.get(base, paths).toString();
    }
}
