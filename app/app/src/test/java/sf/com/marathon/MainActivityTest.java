package sf.com.marathon;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import static org.fest.assertions.api.Assertions.assertThat;

@Config(constants = BuildConfig.class, sdk = 21, manifest = "app/src/main/AndroidManifest.xml")
@RunWith(BasicTestRunner.class)
public class MainActivityTest {

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

        // then
        assertThat(collectionNameView.getText()).isEqualTo("鞋服专送080901期");
        assertThat(weightView.getText()).isEqualTo("1.5-5kg");
        assertThat(minSendPackageView.getText()).isEqualTo("每日最低需寄20件");
    }
}