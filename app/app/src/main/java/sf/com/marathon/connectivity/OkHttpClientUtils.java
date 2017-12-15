package sf.com.marathon.connectivity;

import android.text.TextUtils;
import android.util.Log;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by 01369675 on 2017/7/29.
 */

public class OkHttpClientUtils {

    private static final String CHARSET_NAME = "UTF-8";
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static final OkHttpClient okHttpClient = new OkHttpClient();

    //    public static synchronized OkHttpClient getOkHttpClient() {
//        if (okHttpClient == null) {
//            okHttpClient = new OkHttpClient();
////            CookieHandler cookieHandler=okHttpClient.getCookieHandler();
////            cookieHandler.put();
//
//        }
//        return okHttpClient;
//    }
    static {
        okHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);
    }

    public static String jsssionid = null;


    /**
     * 同步get
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String get(String url) throws Exception {
        Request request = new Request.Builder().url(url).build();

        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 同步get  加sessionId的请求头
     *
     * @param url
     * @return
     * @throws Exception
     */
    public static String get(String url,String sessionId) throws Exception {
        Request.Builder builder = new Request.Builder();
        if (sessionId != null && !sessionId.equals("")) {
            builder.header("Cookie", sessionId);
        }

        Request request = builder.url(url).build();
        Response response = execute(request);


        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 同步get请求
     *
     * @param url
     * @param data
     * @return
     * @throws Exception
     */
    public static String get(String url, Map<String, String> data) throws Exception {
        url = getRequestUrl(url, data);
        Request request = new Request.Builder().url(url).build();

        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 异步get请求
     *
     * @param url
     * @param responseCallback
     * @return
     * @throws Exception
     */
    public static void get(String url, Callback responseCallback) throws Exception {
        Request request = new Request.Builder().url(url).build();

        enqueue(request, responseCallback);
    }

    /**
     * 异步get
     *
     * @param url
     * @param data
     * @param responseCallback
     * @return
     * @throws Exception
     */
    public static void get(String url, Map<String, String> data, Callback responseCallback) throws Exception {
        url = getRequestUrl(url, data);
        Request request = new Request.Builder().url(url).build();

        enqueue(request, responseCallback);
    }

    /**
     * 同步post json数据
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post(String url, String json, String jsessionId) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();
        if (jsessionId != null && !jsessionId.equals("")) {

            builder.header("Cookie", jsessionId);
        }

        Request request = builder.url(url).post(body).build();

        Response response = execute(request);
        Headers headers = response.headers();
        //headers.value(1);
        if (jsessionId == null || jsessionId.trim().length() == 0) {

             List<String> session= headers.values("Set-Cookie");
             String[] ss1;
             String[] ss2;
            ss1=session.get(0).split(";");
            if (session.size()==2){
            ss2 = session.get(1).split(";");
            jsssionid = ss1[0]+";"+ss2[0];
            }else {
                jsssionid = ss1[0];
            }
             Log.e("*******","session数组"+Arrays.toString(session.toArray()));

            Log.e("*******","sessionid"+jsssionid);
//          jsessionId=session.toArray()[0].toString();

        }

        Log.e(">>>>>",">>>>>>>>>>>>>>>>>>>>headers:"+headers.toString());
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 同步post json数据
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();


        Request request = builder.url(url).post(body).build();
        Response response = execute(request);

        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 同步post 键值对数据
     *
     * @param url
     * @param data
     * @return
     * @throws IOException
     */
    public static String post(String url, Map<String, String> data) throws IOException {
        FormEncodingBuilder formBuilder = new FormEncodingBuilder();
        for (Map.Entry<String, String> item : data.entrySet()) {
            formBuilder.add(item.getKey(), item.getValue());
        }

        RequestBody body = formBuilder.build();
        Request request = new Request.Builder().url(url).post(body).build();

        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 异步post json
     *
     * @param url
     * @param json
     * @param responseCallback
     * @throws IOException
     */
    public static void post(String url,String jsessionId, String json, Callback responseCallback) throws IOException {

        //RequestBody body = RequestBody.create(JSON, json);
        Request.Builder builder = new Request.Builder();
        if (jsessionId != null && !jsessionId.equals("")) {
            builder.header("Cookie", jsessionId);
        }
        RequestBody body = RequestBody.create(JSON, json);
        Request request = builder.url(url).post(body).build();
        enqueue(request, responseCallback);
    }

    /**
     * 异步post key-value
     *
     * @param url
     * @param data
     * @param responseCallback
     * @throws IOException
     */
    public static void post(String url, Map<String, String> data, Callback responseCallback) throws IOException {
        FormEncodingBuilder formBuilder = new FormEncodingBuilder();
        for (Map.Entry<String, String> item : data.entrySet()) {
            formBuilder.add(item.getKey(), item.getValue());
        }

        RequestBody body = formBuilder.build();
        Request request = new Request.Builder().url(url).post(body).build();

        enqueue(request, responseCallback);
    }

    /**
     * 同步put
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    public static String put(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder().url(url).put(body).build();

        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 同步put key-value
     *
     * @param url
     * @param data
     * @return
     * @throws IOException
     */
    public static String put(String url, Map<String, String> data) throws IOException {
        FormEncodingBuilder formBuilder = new FormEncodingBuilder();
        for (Map.Entry<String, String> item : data.entrySet()) {
            formBuilder.add(item.getKey(), item.getValue());
        }

        RequestBody body = formBuilder.build();
        Request request = new Request.Builder().url(url).put(body).build();

        Response response = execute(request);
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    /**
     * 异步put json
     *
     * @param url
     * @param json
     * @throws IOException
     */
    public static void put(String url, String json, Callback responseCallback) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder().url(url).put(body).build();
        enqueue(request, responseCallback);
    }

    /**
     * 异步put key-value
     *
     * @param url
     * @param data
     * @param responseCallback
     * @throws IOException
     */
    public static void put(String url, Map<String, String> data, Callback responseCallback) throws IOException {
        FormEncodingBuilder formBuilder = new FormEncodingBuilder();
        for (Map.Entry<String, String> item : data.entrySet()) {
            formBuilder.add(item.getKey(), item.getValue());
        }

        RequestBody body = formBuilder.build();
        Request request = new Request.Builder().url(url).put(body).build();

        enqueue(request, responseCallback);
    }

    /**
     * 通用同步请求。
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static Response execute(Request request) throws IOException {


        String head = request.headers().toString();
        Log.e("head", "head:" + head);
        return okHttpClient.newCall(request).execute();
    }

    /**
     * 通用异步请求
     *
     * @param request
     * @param responseCallback
     */
    public static void enqueue(Request request, Callback responseCallback) {
        okHttpClient.newCall(request).enqueue(responseCallback);
    }

    /**
     * 开启异步线程访问网络, 且不在意返回结果（实现空callback）
     *
     * @param request
     */
    public static void enqueue(Request request) {
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(Response arg0) throws IOException {
                //
            }

            @Override
            public void onFailure(Request arg0, IOException arg1) {
                //
            }
        });
    }

    public static String getStringFromServer(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = execute(request);
        if (response.isSuccessful()) {
            String responseUrl = response.body().string();
            return responseUrl;
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }


    /**
     * 这里使用了HttpClinet的API。只是为了方便
     *
     * @param params
     * @return
     */
    //public static String formatParams(List<BasicNameValuePair> params) {
    //  return URLEncodedUtils.format(params, CHARSET_NAME);
    //}

    /**
     * 为HttpGet 的 url 方便的添加多个name value 参数。
     *
     * @param url
     * @param params
     * @return
     */
    // public static String attachHttpGetParams(String url, List<BasicNameValuePair> params) {
    //   return url + "?" + formatParams(params);
    //}

    /**
     * 为HttpGet 的 url 方便的添加1个name value 参数。
     *
     * @param url
     * @param name
     * @param value
     * @return
     */
    public static String attachHttpGetParam(String url, String name, String value) {
        return url + "?" + name + "=" + value;
    }

    /**
     * get方式URL拼接
     *
     * @param url
     * @param map
     * @return
     */
    private static String getRequestUrl(String url, Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return url;
        } else {
            StringBuilder newUrl = new StringBuilder(url);
            if (url.indexOf("?") == -1) {
                newUrl.append("?rd=" + Math.random());
            }

            for (Map.Entry<String, String> item : map.entrySet()) {
                if (false == TextUtils.isEmpty(item.getKey().trim())) {
                    try {
                        newUrl.append("&" + item.getKey().trim() + "=" + URLEncoder.encode(String.valueOf(item.getValue().trim()), "UTF-8"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            return newUrl.toString();
        }
    }
}
