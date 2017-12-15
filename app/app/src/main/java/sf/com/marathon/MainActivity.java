package sf.com.marathon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import sf.com.marathon.activities.SignUpActivity;
import sf.com.marathon.connectivity.TransferManager;
import sf.com.marathon.contact.Pack;
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
        TransferManager.buildClient(getApplicationContext(), URL_GET_COLLECTION_INFORMATION)
                .withOnSuccessListener(new TransferManager.OnSuccessListener() {
                    @Override
                    public void onSuccess(String json) {
                        showMarketInformation(GsonUtils.json2Bean(json, Pack.class));
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

        View joinButton = findViewById(R.id.join_view);
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showMarketInformation(Pack pack) {
        collectionNameView.setText(pack.getMarketName());
        weightView.setText(String.format(getString(R.string.weight_format), pack.getMinWeight(), pack.getMaxWeight()));
        minSendPackageView.setText(String.format(getString(R.string.count_of_day), pack.getDailyMinPackages()));
    }
}
