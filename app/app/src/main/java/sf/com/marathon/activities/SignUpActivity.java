package sf.com.marathon.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sf.com.marathon.R;
import sf.com.marathon.connectivity.TransferManager;
import sf.com.marathon.utils.StringUtils;
import sf.com.marathon.utils.ToastUtils;

import static sf.com.marathon.utils.StringUtils.isBiggerThanAndEquals;
import static sf.com.marathon.utils.StringUtils.isNotEmpty;

public class SignUpActivity extends BaseActivity {

    private TextView addressSelectView;
    private Button signUpButton;
    private EditText addressEditView;
    private EditText senderNameView;
    private EditText senderPhoneView;
    private EditText countView;
    private EditText weightEditView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_up_activity);

        initUi();
        initListener();

        signUp();
    }

    private void initListener() {
        addressSelectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInformation();
            }
        });
    }

    private void validateInformation() {
        List<Validator> validators = new ArrayList<>();
        validators.add(new DivisionValidator());
        validators.add(new AddressValidator());

        validators.add(new NameValidator());
        validators.add(new PhoneValidator());

        validators.add(new CountOfDailyValidator());
        validators.add(new WeightValidator());

        for (Validator validator : validators) {
            if (!validator.validator(validator.getValue())) {
                ToastUtils.showLong(getApplicationContext(), validator.errorTip());
                return;
            }
        }

        signUp();
    }

    private void signUp() {
        TransferManager.buildClient(getApplicationContext(), "/hello")
                .withOnFailedListener(new TransferManager.OnFailedListener() {
                    @Override
                    public void onFailed(String message, int errorType) {

                    }
                })
                .withOnSuccessListener(new TransferManager.OnSuccessListener() {
                    @Override
                    public void onSuccess(String json) {

                    }
                })
                .get();
    }

    private void initUi() {
        addressSelectView = findViewById(R.id.address_select_text_view);
        addressEditView = findViewById(R.id.address_edit_view);
        senderNameView = findViewById(R.id.sender_name_view);
        senderPhoneView = findViewById(R.id.sender_phone_view);
        countView = findViewById(R.id.count_view);
        weightEditView = findViewById(R.id.weight_edit_view);

        signUpButton = findViewById(R.id.sign_up_button);
    }

    public class DivisionValidator implements Validator<String> {
        @Override
        public boolean validator(String division) {
            return isNotEmpty(division);
        }

        @Override
        public int errorTip() {
            return R.string.error_division;
        }

        @Override
        public String getValue() {
            return addressSelectView.getText().toString();
        }
    }

    public class AddressValidator implements Validator<String> {
        @Override
        public boolean validator(String address) {
            return isNotEmpty(address);
        }

        @Override
        public int errorTip() {
            return R.string.error_address;
        }

        @Override
        public String getValue() {
            return addressEditView.getText().toString();
        }
    }

    public class NameValidator implements Validator<String> {
        @Override
        public boolean validator(String name) {
            return StringUtils.isNotEmpty(name);
        }

        @Override
        public int errorTip() {
            return R.string.error_name;
        }

        @Override
        public String getValue() {
            return senderNameView.getText().toString();
        }
    }


    public class PhoneValidator implements Validator<String> {
        @Override
        public boolean validator(String phone) {
            return StringUtils.isMobileNumber(phone);
        }

        @Override
        public int errorTip() {
            return R.string.error_phone;
        }

        @Override
        public String getValue() {
            return senderPhoneView.getText().toString();
        }
    }

    public class CountOfDailyValidator implements Validator<String> {
        @Override
        public boolean validator(String count) {
            return StringUtils.isInteger(count) && isBiggerThanAndEquals(count, 20);
        }

        @Override
        public int errorTip() {
            return R.string.error_count;
        }

        @Override
        public String getValue() {
            return countView.getText().toString();
        }
    }

    public class WeightValidator implements Validator<String> {
        @Override
        public boolean validator(String weight) {
            return StringUtils.isDouble(weight);
        }

        @Override
        public int errorTip() {
            return R.string.error_weight;
        }

        @Override
        public String getValue() {
            return weightEditView.getText().toString();
        }
    }

    public interface Validator<T> {
        boolean validator(T t);

        int errorTip();

        String getValue();
    }
}