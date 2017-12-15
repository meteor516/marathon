package sf.com.marathon.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

import static android.content.Context.TELEPHONY_SERVICE;

public class DeviceUtil {

    private DeviceUtil() {
    }

    public static String deviceId(Context context) {
        TelephonyManager TelephonyMgr = (TelephonyManager) context.getSystemService(TELEPHONY_SERVICE);

        return TelephonyMgr.getDeviceId();
    }
}
