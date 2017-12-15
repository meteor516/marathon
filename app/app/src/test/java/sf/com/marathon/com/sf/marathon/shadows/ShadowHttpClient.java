package sf.com.marathon.com.sf.marathon.shadows;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import okhttp3.OkHttpClient;

@Implements(OkHttpClient.class)
public class ShadowHttpClient {
    private static String requestUrl;
    private static String requestParameter;

    @Implementation
    public void get() {

    }

    @Implementation
    public void post() {

    }

    public static void fakeRequestUrl(String requestUrl) {
        ShadowHttpClient.requestUrl = requestUrl;
    }

    public static void fakeRequestParameters(String requestParameter) {
        ShadowHttpClient.requestParameter = requestParameter;
    }

    public void reset() {
        requestParameter = null;
        requestUrl = null;
    }
}
