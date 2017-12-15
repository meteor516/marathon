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
import sf.com.marathon.contact.Pack;
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
        String json = "{marketName=鞋服转送, dailyMinPackages=20.0, minWeight=1.5, maxWeight=5.0, basePrice=6.0, baseWeight=1.5, groupLimit=20.0, groupDuration=3.0, useRequire=1.\t每日承诺寄件量不低于20件（周六日及法定假期不要求承诺量）\n" +
                "日发件不足20件或运费不足120元将收取最低运作费用\n" +
                "2.\t承诺使用周期内提前终止寄件是为违约行为, beginTime=1.513349492E12, endTime=1.513346965E12, groupNum=null, finish=null, createTime=1.513331933046E12, finishTime=null, proId=1, packId=1}";   // given

        Pack transferResult = GsonUtils.json2Bean(json, Pack.class);
        System.out.println(transferResult);
    }
}