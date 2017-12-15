package sf.com.marathon;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import sf.com.marathon.beans.CollectionInformation;
import sf.com.marathon.com.sf.marathon.shadows.ShadowHttpClient;
import sf.com.marathon.utils.GsonUtils;

import static org.fest.assertions.api.Assertions.assertThat;

@Config(constants = BuildConfig.class, sdk = 21, manifest = "app/src/main/AndroidManifest.xml", shadows = {ShadowHttpClient.class})
@RunWith(BasicTestRunner.class)
public class MainActivityTest {

    @Before
    public void setup() {
        fakeResponse();
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

    private void fakeResponse() {
        CollectionInformation collectionInformation = new CollectionInformation();
        collectionInformation.setName("鞋服专送080901期");
        collectionInformation.setMinWeight(1.5);
        collectionInformation.setMaxWeight(5);
        collectionInformation.setCountOfDayWithSending(20);

        String bean2Json = GsonUtils.bean2Json(collectionInformation);
        ShadowHttpClient.fakeResult(bean2Json);
    }
}