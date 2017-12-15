package sf.com.marathon.utils;

public class StringUtils {

    public static boolean isEmpty(String anyString) {
        return anyString == null || anyString.equals("");
    }

    public static boolean isNotEmpty(String anyString) {
        return !isEmpty(anyString);
    }
}