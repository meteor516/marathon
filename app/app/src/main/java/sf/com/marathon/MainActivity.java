package sf.com.marathon;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import sf.com.marathon.beans.CollectionInformation;
import sf.com.marathon.connectivity.HttpClient;
import sf.com.marathon.utils.GsonUtils;

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
        AsyncTask<String, String, String> asyncTask = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String[] params) {
                return HttpClient.httpClient().get(URL_GET_COLLECTION_INFORMATION);
            }

            @Override
            protected void onPostExecute(String json) {
                CollectionInformation collectionInformation = GsonUtils.json2Bean(json, CollectionInformation.class);

                super.onPostExecute(json);
                showInformation(collectionInformation);
            }
        };
        asyncTask.execute("");
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
