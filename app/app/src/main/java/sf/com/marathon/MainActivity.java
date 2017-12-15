package sf.com.marathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import sf.com.marathon.beans.CollectionInformation;
import sf.com.marathon.connectivity.TransferManager;
import sf.com.marathon.utils.GsonUtils;
import sf.com.marathon.utils.ToastUtils;

import static sf.com.marathon.utils.UrlConstants.URL_GET_COLLECTION_INFORMATION;

public class MainActivity extends AppCompatActivity {

    private TextView collectionNameView;
    private TextView weightView;
    private TextView minSendPackageView;
    private Toolbar toolbar;

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
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    private void showInformation(CollectionInformation collectionInformation) {
        collectionNameView.setText(collectionInformation.getName());
        weightView.setText(String.format(getString(R.string.weight_format), collectionInformation.getMinWeight(), collectionInformation.getMaxWeight()));
        minSendPackageView.setText(String.format(getString(R.string.count_of_day), collectionInformation.getCountOfDayWithSending()));
    }
}
