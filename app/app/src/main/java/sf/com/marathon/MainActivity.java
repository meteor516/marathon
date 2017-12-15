package sf.com.marathon;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.net.URL;

import sf.com.marathon.beans.CollectionInformation;
import sf.com.marathon.connectivity.HttpClient;
import sf.com.marathon.connectivity.TransferManager;
import sf.com.marathon.utils.GsonUtils;
import sf.com.marathon.utils.ToastUtils;

import static sf.com.marathon.utils.UrlConstants.URL_GET_COLLECTION_INFORMATION;

public class MainActivity extends Activity {

    private TextView collectionNameView;
    private TextView weightView;
    private TextView minSendPackageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        initUi();

        requestAndShowInformation();
    }

    private void requestAndShowInformation() {
        TransferManager.buildClient(URL_GET_COLLECTION_INFORMATION)
                .withOnSuccessListener(new TransferManager.OnSuccessListener() {
                    @Override
                    public void onSuccess(String json) {
                        CollectionInformation collectionInformation = GsonUtils.json2Bean(json, CollectionInformation.class);
                        showInformation(collectionInformation);
                    }
                })
                .withOnFailedListener(new TransferManager.OnFailedListener() {
                    @Override
                    public void onFailed(String message, int errorType) {
                        ToastUtils.showLong(getApplicationContext(), message);
                    }
                });
    }

    private void initUi() {
        collectionNameView = findViewById(R.id.collection_name_view);
        weightView = findViewById(R.id.weight_view);
        minSendPackageView = findViewById(R.id.min_send_package_view);
    }

    private void showInformation(CollectionInformation collectionInformation) {
        collectionNameView.setText(collectionInformation.getName());
        weightView.setText(String.format(getString(R.string.weight_format), collectionInformation.getMinWeight(), collectionInformation.getMaxWeight()));
        minSendPackageView.setText(String.format(getString(R.string.count_of_day), collectionInformation.getCountOfDayWithSending()));
    }
}
