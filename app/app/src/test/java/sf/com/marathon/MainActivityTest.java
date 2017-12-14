package sf.com.marathon;

import android.widget.TextView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import sf.com.marathon.com.sf.marathon.BasicTestRunner;

import static org.fest.assertions.api.Assertions.assertThat;

@Config(constants = BuildConfig.class, sdk = 21, manifest = "app/src/main/AndroidManifest.xml")
@RunWith(BasicTestRunner.class)
public class MainActivityTest {

    @Test
    public void should_show_text() {
        // given
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        TextView textView = mainActivity.findViewById(R.id.test_text_view);

        // when

        // then
        assertThat(textView.getText()).isEqualTo("test");
    }
}