package sf.com.marathon.com.sf.marathon.shadows;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import sf.com.marathon.connectivity.HttpClient;

@Implements(HttpClient.class)
public class ShadowHttpClient {
    public static String requestUrl;
    private static String requestParameter;
    private static String responseResultAsJson;


    @Implementation
    public String get(String requestUrl) {
        ShadowHttpClient.requestUrl = requestUrl;
        return responseResultAsJson;
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

    public static void fakeResult(String repsonseResultAsJson) {
        ShadowHttpClient.responseResultAsJson = repsonseResultAsJson;
    }

    public void reset() {
        requestParameter = null;
        requestUrl = null;
        responseResultAsJson = null;
    }
}
