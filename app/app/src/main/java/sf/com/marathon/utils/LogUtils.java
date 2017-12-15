package sf.com.marathon.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 * Log工具，类似android.util.Log。
 * tag自动产生，格式: CUSTOM_TAG_PREFIX:className.methodName(L:lineNumber),
 * customTagPrefix为空时只输出：className.methodName(L:lineNumber)。
 */
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

    public static void d(String content, Throwable tr) {
        String tag = generateTag();

        Log.d(tag, content, tr);
    }

    public static void e(String content) {
        String tag = generateTag();

        Log.e(tag, content);
    }

    public static void e(String content, Throwable tr) {
        String tag = generateTag();

        Log.e(tag, content, tr);
    }

//    public static void i(String content) {
//        String tag = generateTag();
//
//        Log.i(tag, content);
//    }
//
//    public static void i(String content, Throwable tr) {
//        String tag = generateTag();
//
//        Log.i(tag, content, tr);
//    }
//
//    public static void v(String content) {
//        String tag = generateTag();
//
//        Log.v(tag, content);
//    }
//
//    public static void v(String content, Throwable tr) {
//        String tag = generateTag();
//
//        Log.v(tag, content, tr);
//    }
//
//    public static void w(String content) {
//        String tag = generateTag();
//
//        Log.w(tag, content);
//    }
//
//    public static void w(String content, Throwable tr) {
//        String tag = generateTag();
//
//        Log.w(tag, content, tr);
//    }
//
//    public static void w(Throwable tr) {
//        String tag = generateTag();
//
//        Log.w(tag, tr);
//    }
//
//
//    public static void wtf(String content) {
//        String tag = generateTag();
//
//        Log.wtf(tag, content);
//    }
//
//    public static void wtf(String content, Throwable tr) {
//        String tag = generateTag();
//
//        Log.wtf(tag, content, tr);
//    }
//
//    public static void wtf(Throwable tr) {
//        String tag = generateTag();
//
//        Log.wtf(tag, tr);
//    }

}

