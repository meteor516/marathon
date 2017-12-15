package sf.com.marathon.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import sf.com.marathon.R;

public class QRCodeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.qr_code_layout);

        TextView weightView = findViewById(R.id.weight_view);

    }
}
