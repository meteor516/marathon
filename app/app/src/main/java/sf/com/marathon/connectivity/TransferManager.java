package sf.com.marathon.connectivity;

import android.os.AsyncTask;

public final class TransferManager {

    private OnSuccessListener onSuccessListener;
    private OnFailedListener onFailedListener;
    private String url;

    private TransferManager() {

    }

    public static TransferManager buildClient(String url) {
        TransferManager transferManager = new TransferManager();
        transferManager.url = url;
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
                RequestResult requestResult = HttpClient.httpClient().get(url);
                return requestResult;
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

