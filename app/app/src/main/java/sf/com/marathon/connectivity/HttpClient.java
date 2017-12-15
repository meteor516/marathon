package sf.com.marathon.connectivity;

import android.util.Log;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

import sf.com.marathon.utils.LogUtils;

public class HttpClient {

    private static HttpClient httpClient;
    private static final OkHttpClient realHttpClient = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private HttpClient() {
    }

    public static HttpClient httpClient() {
        if (httpClient == null) {
            httpClient = new HttpClient();
        }

        return httpClient;
    }

    public RequestResult post(String url, String json) {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();


        Request request = builder.url(url).post(body).build();
        Response response = null;
        try {
            response = execute(request);
            return response.isSuccessful()
                    ? RequestResult.success(response.body().string())
                    : RequestResult.failed(-1, "服务器异常");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return RequestResult.UN_KNOWN;
    }

    public RequestResult get(String url) {
        try {
            Response response = execute(new Request.Builder().url(url).build());

            return response.isSuccessful()
                    ? RequestResult.success(response.body().string())
                    : RequestResult.failed(-1, "服务器异常");
        } catch (IOException e) {
            LogUtils.e(e.getMessage(),e);
        }

        return RequestResult.UN_KNOWN;
    }

    private static Response execute(Request request) throws IOException {
        String head = request.headers().toString();
        Log.e("head", "head:" + head);

        return realHttpClient.newCall(request).execute();
    }
}
