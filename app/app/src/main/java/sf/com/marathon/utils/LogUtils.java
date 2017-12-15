package sf.com.marathon.utils;

import android.text.TextUtils;
import android.util.Log;

public class LogUtils {

    private static final String CUSTOM_TAG_PREFIX = "";

    private LogUtils() {
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        tag = String.format(tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = TextUtils.isEmpty(CUSTOM_TAG_PREFIX) ? tag : String.format("%s:%s", CUSTOM_TAG_PREFIX, tag);
        return tag;
    }

    public static void d(String content) {
        String tag = generateTag();

        Log.d(tag, content);
    }

    public static void e(String content) {
        String tag = generateTag();

        Log.e(tag, content);
    }

    public static void e(String content, Throwable tr) {
        String tag = generateTag();

        Log.e(tag, content, tr);
    }

}

