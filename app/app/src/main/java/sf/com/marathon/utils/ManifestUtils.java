package sf.com.marathon.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class ManifestUtils {
    private ManifestUtils() {
    }

    public static String getValueByKey(Context context, String key) {
        String value = "";
        try {
            ApplicationInfo e = getApplicationInfo(context);
            if (e != null) {
                value = e.metaData.get(key) + "";
            }
        } catch (Exception var4) {
            LogUtils.e(var4.getMessage(), var4);
        }

        return value;
    }

    private static ApplicationInfo getApplicationInfo(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(),
                PackageManager.GET_META_DATA);
    }
}