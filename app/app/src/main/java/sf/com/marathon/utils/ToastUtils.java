package sf.com.marathon.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {
    private ToastUtils() {

    }

    public static void showShort(Context context, int resId) {
        showMessageWithResId(context, resId, Toast.LENGTH_SHORT);
    }

    public static void showShort(Context context, String message) {
        showMessageWithResource(context, message, Toast.LENGTH_SHORT);
    }

    public static void showLong(Context context, int resId) {
        showMessageWithResId(context, resId, Toast.LENGTH_LONG);
    }

    public static void showLong(Context context, String message) {
        showMessageWithResource(context, message, Toast.LENGTH_LONG);
    }

    private static void showMessageWithResource(Context context, String message, int durationType) {
        Toast.makeText(context, message, durationType).show();
    }

    private static void showMessageWithResId(Context context, int resId, int durationType) {
        Toast.makeText(context, resId, durationType).show();
    }
}