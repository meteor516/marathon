package sf.com.marathon;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import sf.com.marathon.connectivity.HttpClient;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        TextView collectionNameView = findViewById(R.id.collection_name_view);
        TextView weightView = findViewById(R.id.weight_view);
        TextView minSendPackageView = findViewById(R.id.min_send_package_view);

        AsyncTask<String, String, String> asyncTask = new AsyncTask<String, String, String>() {
            @Override
            protected String doInBackground(String[] params) {
                return HttpClient.httpClient().get("getCollectionInformation");
            }

            @Override
            protected void onPostExecute(String s) {

                super.onPostExecute(s);
            }
        };
    }
}
