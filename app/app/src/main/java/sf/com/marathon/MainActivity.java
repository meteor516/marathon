package sf.com.marathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import sf.com.marathon.connectivity.TransferManager;
import sf.com.marathon.contact.ProMarketBase;
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
        TransferManager.buildClient(getApplicationContext(), URL_GET_COLLECTION_INFORMATION)
                .withOnSuccessListener(new TransferManager.OnSuccessListener() {
                    @Override
                    public void onSuccess(String json) {
                        ProMarketBase proMarketBase = GsonUtils.json2Bean(json, ProMarketBase.class);
                        showMarketInformation(proMarketBase);
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
        collectionNameView = (TextView) findViewById(R.id.collection_name_view);
        weightView = (TextView) findViewById(R.id.weight_view);
        minSendPackageView = (TextView) findViewById(R.id.min_send_package_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
    }

    private void showMarketInformation(ProMarketBase proMarketBase) {
        collectionNameView.setText(proMarketBase.getMarketName());
        weightView.setText(String.format(getString(R.string.weight_format), proMarketBase.getMinWeight(), proMarketBase.getMaxWeight()));
        minSendPackageView.setText(String.format(getString(R.string.count_of_day), proMarketBase.getDailyMinPackages()));
    }
}
