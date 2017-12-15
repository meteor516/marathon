package sf.com.marathon.connectivity;

import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

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

    public String get(String url) {
        Request request = new Request.Builder().url(url).build();

        Response response;
        try {
            response = execute(request);
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
//            throw new IOException("Unexpected code " + response);
            }} catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


    private static Response execute(Request request) throws IOException {
        String head = request.headers().toString();
        Log.e("head", "head:" + head);
        return realHttpClient.newCall(request).execute();
    }

    public void post() {

    }
}
