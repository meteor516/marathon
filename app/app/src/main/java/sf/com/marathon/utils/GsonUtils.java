package sf.com.marathon.utils;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private static Gson mGson = new GsonBuilder().disableHtmlEscaping().create();

    private GsonUtils() {

    }

    public static <T> T json2Bean(String result, Class<T> clazz) {
        return mGson.fromJson(result, clazz);
    }

    public static String bean2Json(Object obj) {
        return mGson.toJson(obj);
    }

}
