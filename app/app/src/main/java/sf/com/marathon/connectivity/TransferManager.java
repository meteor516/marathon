package sf.com.marathon.connectivity;

import android.Manifest;
import android.content.Context;
import android.os.AsyncTask;

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
                if (requestResult.isSuccess()) {
                    onSuccessListener.onSuccess(requestResult.resultAsJson());
                    return;
                }
                onFailedListener.onFailed(requestResult.errorMessage(), requestResult.errorCode());
            }
        }.execute();
    }

    public interface OnFailedListener {
        void onFailed(String message, int errorType);
    }

    public interface OnSuccessListener {
        void onSuccess(String json);
    }
}

