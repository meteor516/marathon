package sf.com.marathon.connectivity;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import sf.com.marathon.utils.LogUtils;

public class HttpClient {

    private static HttpClient httpClient;
    private static final OkHttpClient realHttpClient = new OkHttpClient();

    private HttpClient() {
    }

    public static HttpClient httpClient() {
        if (httpClient == null) {
            httpClient = new HttpClient();
        }

        return httpClient;
    }

    public RequestResult get(String url) {
        try {
            Response response = execute(new Request.Builder().url(url).build());
            return response.isSuccessful()
                    ? RequestResult.success(response.body().string())
                    : RequestResult.failed(-1, "服务器异常");
        } catch (IOException e) {
            LogUtils.e(e.getMessage());
        }

        return RequestResult.UN_KNOWN;
    }

    private static Response execute(Request request) throws IOException {
        String head = request.headers().toString();
        Log.e("head", "head:" + head);
        return realHttpClient.newCall(request).execute();
    }
}
