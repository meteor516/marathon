package sf.com.marathon;

import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import sf.com.marathon.beans.CollectionInformation;
import sf.com.marathon.com.sf.marathon.shadows.ShadowHttpClient;
import sf.com.marathon.contact.ProMarketBase;
import sf.com.marathon.contact.TransferResult;
import sf.com.marathon.utils.GsonUtils;

import static org.fest.assertions.api.Assertions.assertThat;

@Config(constants = BuildConfig.class, sdk = 21, manifest = "app/src/main/AndroidManifest.xml", shadows = {ShadowHttpClient.class})
@RunWith(BasicTestRunner.class)
public class MainActivityTest {

    @Before
    public void setup() {
        fakeResponse();
    }

    @After
    public void tearDown() {
        ShadowHttpClient.reset();
    }

    @Test
    public void should_show_goods_information_when_on_create() {
        // given
        ActivityController<MainActivity> mainActivityActivityController = Robolectric.buildActivity(MainActivity.class);

        // when
        mainActivityActivityController.create();
        MainActivity mainActivity = mainActivityActivityController.get();
        TextView collectionNameView = mainActivity.findViewById(R.id.collection_name_view);
        TextView weightView = mainActivity.findViewById(R.id.weight_view);
        TextView minSendPackageView = mainActivity.findViewById(R.id.min_send_package_view);

//        ShadowLooper.runMainLooperOneTask();

        // then
        assertThat(collectionNameView.getText()).isEqualTo("鞋服专送080901期");
        assertThat(minSendPackageView.getText()).isEqualTo("每日最低需寄20件");
        assertThat(ShadowHttpClient.requestUrl).isEqualTo("/getCollectionInformation");
        assertThat(weightView.getText()).isEqualTo("1.5-5.0kg");
    }


    @Test
    public void should_show_error_message_when_request_failed() {
        // given

        // when

        // then
    }

    private void fakeRequestFailed(String errorMessage) {
        ShadowHttpClient.fakeErrorMessage(errorMessage);
    }

    private void fakeResponse() {
        ProMarketBase proMarketBase = new ProMarketBase();
        proMarketBase.setMarketName("鞋服专送080901期");
        proMarketBase.setMinWeight(1.5);
        proMarketBase.setMaxWeight(5);
        proMarketBase.setDailyMinPackages(20);

        String bean2Json = GsonUtils.bean2Json(proMarketBase);
        ShadowHttpClient.fakeResult(bean2Json);
    }

    @Test
    public void should_parse_json() {
        String json = "{\"errorMsg\":null,\"response\":{\"marketName\":null,\"dailyMinPackages\":null,\"minWeight\":null,\"maxWeight\":null,\"basePrice\":null,\"baseWeight\":22.0,\"groupLimit\":null,\"groupDuration\":null,\"useRequire\":null,\"beginTime\":1513349492000,\"endTime\":1513346965000,\"groupNum\":null,\"finish\":null,\"createTime\":1513328514172,\"finishTime\":null},\"isSuccess\":true}";   // given

        TransferResult transferResult = GsonUtils.json2Bean(json, TransferResult.class);
        System.out.println(transferResult);
    }
}