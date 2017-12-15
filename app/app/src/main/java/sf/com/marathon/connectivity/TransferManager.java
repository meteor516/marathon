package sf.com.marathon.connectivity;

import android.content.Context;
import android.os.AsyncTask;

import sf.com.marathon.contact.TransferResult;
import sf.com.marathon.utils.GsonUtils;

import static sf.com.marathon.utils.ManifestUtils.getValueByKey;

public final class TransferManager {

    private OnSuccessListener onSuccessListener;
    private OnFailedListener onFailedListener;
    private String realUrl;

    private TransferManager() {

    }

    public static TransferManager buildClient(Context context, String url) {
        TransferManager transferManager = new TransferManager();

        transferManager.realUrl = getValueByKey(context, "SERVER") + url;

        return transferManager;
    }

    public TransferManager withOnSuccessListener(OnSuccessListener onSuccessListener) {
        this.onSuccessListener = onSuccessListener;
        return this;
    }

    public TransferManager withOnFailedListener(OnFailedListener onFailedListener) {
        this.onFailedListener = onFailedListener;
        return this;
    }

    public void get() {
        new AsyncTask<String, String, RequestResult>() {
            @Override
            protected RequestResult doInBackground(String[] params) {
                return HttpClient.httpClient().get(realUrl);
            }

            @Override
            protected void onPostExecute(RequestResult requestResult) {
                if (!requestResult.isSuccess()) {
                    onFailedListener.onFailed(requestResult.errorMessage(), requestResult.errorCode());
                    return;
                }

                try {
                    TransferResult transferResult = GsonUtils.json2Bean(requestResult.resultAsJson(), TransferResult.class);
                    if (transferResult.isSuccess()) {
                        onSuccessListener.onSuccess(transferResult.getResponse().toString());
                        return;
                    }
                } catch (Exception e) {
                    onFailedListener.onFailed("数据解析异常", requestResult.errorCode());
                    return;
                }

                onFailedListener.onFailed(requestResult.errorMessage(), requestResult.errorCode());
            }
        }.execute();
    }

    public void post(String json) {
        new AsyncTask<String, String, RequestResult>() {
            @Override
            protected RequestResult doInBackground(String[] params) {
                return HttpClient.httpClient().post(realUrl, params[0]);
            }

            @Override
            protected void onPostExecute(RequestResult requestResult) {
                if (!requestResult.isSuccess()) {
                    onFailedListener.onFailed(requestResult.errorMessage(), requestResult.errorCode());
                    return;
                }

                try {
                    TransferResult transferResult = GsonUtils.json2Bean(requestResult.resultAsJson(), TransferResult.class);
                    if (transferResult.isSuccess()) {
                        onSuccessListener.onSuccess(transferResult.getResponse().toString());
                        return;
                    }
                } catch (Exception e) {
                    onFailedListener.onFailed("数据解析异常", requestResult.errorCode());
                    return;
                }

                onFailedListener.onFailed(requestResult.errorMessage(), requestResult.errorCode());
            }
        }.execute(json);
    }

    public interface OnFailedListener {
        void onFailed(String message, int errorType);
    }

    public interface OnSuccessListener {
        void onSuccess(String json);
    }
}

