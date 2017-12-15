package sf.com.marathon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import chihane.jdaddressselector.BottomDialog;
import chihane.jdaddressselector.OnAddressSelectedListener;
import chihane.jdaddressselector.model.City;
import chihane.jdaddressselector.model.County;
import chihane.jdaddressselector.model.Province;
import chihane.jdaddressselector.model.Street;
import sf.com.marathon.R;
import sf.com.marathon.connectivity.TransferManager;
import sf.com.marathon.contact.SignUpBean;
import sf.com.marathon.utils.GsonUtils;
import sf.com.marathon.utils.StringUtils;
import sf.com.marathon.utils.ToastUtils;
import sf.com.marathon.utils.UrlConstants;

import static sf.com.marathon.utils.DeviceUtil.deviceId;
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
    private View backButton;
    private String packId;
    private String proId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sign_up_activity);

        initUi();
        initListener();
        extractValue();

        signUp();
    }

    private void extractValue() {
        Intent intent = getIntent();
        packId = (String) intent.getSerializableExtra("packId");
        proId = (String) intent.getSerializableExtra("proId");
    }

    private void initListener() {
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        addressSelectView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddressSelect();
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateInformation();
            }
        });
    }

    private void showAddressSelect() {
        BottomDialog dialog = new BottomDialog(SignUpActivity.this);
        dialog.setCancelable(true);
        dialog.setOnAddressSelectedListener(new OnAddressSelectedListener() {
            @Override
            public void onAddressSelected(Province province, City city, County county, Street street) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(province.name).append(city.name).append(county == null ? "" : county.name);
                addressSelectView.setText(stringBuilder.toString());
            }
        });
        dialog.show();
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
        SignUpBean signUpBean = new SignUpBean();

        signUpBean.setPackId(packId);
        signUpBean.setGroupTime(new Date());
        signUpBean.setRegion(addressSelectView.getText().toString() + addressEditView.getText().toString());
        signUpBean.setUserName(deviceId(getApplicationContext()));
        signUpBean.setProId(proId);

        TransferManager.buildClient(getApplicationContext(), UrlConstants.URL_SIGN_UP)
                .withOnFailedListener(new TransferManager.OnFailedListener() {
                    @Override
                    public void onFailed(String message, int errorType) {
                        ToastUtils.showLong(getApplicationContext(), String.format("请求失败,错误原因是%s", message));
                    }
                })
                .withOnSuccessListener(new TransferManager.OnSuccessListener() {
                    @Override
                    public void onSuccess(String json) {
                        ToastUtils.showLong(getApplicationContext(), "报名成功");

                        finish();
                    }
                })
                .post(GsonUtils.bean2Json(signUpBean));
    }

    private void initUi() {
        addressSelectView = findViewById(R.id.address_select_text_view);
        addressEditView = findViewById(R.id.address_edit_view);
        senderNameView = findViewById(R.id.sender_name_view);
        senderPhoneView = findViewById(R.id.sender_phone_view);
        countView = findViewById(R.id.count_view);
        weightEditView = findViewById(R.id.weight_edit_view);

        signUpButton = findViewById(R.id.sign_up_button);
        backButton = findViewById(R.id.back_button);
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