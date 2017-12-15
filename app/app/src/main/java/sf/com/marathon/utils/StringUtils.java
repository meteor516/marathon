package sf.com.marathon.utils;

import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    public static final String MOBILE_FORMAT_EXPRESS = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
    public static final String INTEGER_FORMAT_EXPRESS = "^-?[1-9]\\d*$";
    public static final String SIGNED_FORMAT_EXPRESS = "^[0-9]+\\.{0,1}[0-9]{0,2}$";

    private StringUtils() {
    }

    public static boolean isEmpty(String anyString) {
        return anyString == null || "".equals(anyString);
    }

    public static boolean isNotEmpty(String anyString) {
        return !isEmpty(anyString);
    }

    public static boolean isMobileNumber(String mobileNumber) {
        return isMatch(mobileNumber, MOBILE_FORMAT_EXPRESS);
    }

    public static boolean isInteger(String anyString) {
        return isMatch(anyString, INTEGER_FORMAT_EXPRESS);
    }

    public static boolean isBiggerThanAndEquals(String integerString, int target) {
        return Integer.valueOf(integerString) >= target;
    }

    public static String getFormatDate(Date date) {
        return new SimpleDateFormat("MM:dd").format(date);
    }

    private static boolean isMatch(String anyString, String integerFormatExpress) {
        if (isEmpty(anyString)) {
            return false;
        }

        Pattern pattern = Pattern.compile(integerFormatExpress);
        Matcher isNum = pattern.matcher(anyString);

        return isNum.matches();
    }

    public static boolean isDouble(String anyString) {
        return isMatch(anyString, SIGNED_FORMAT_EXPRESS);
    }
}