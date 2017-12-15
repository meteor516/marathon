package sf.com.marathon.activities;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

public class BaseActivity extends Activity{
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager systemService = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

        if (getCurrentFocus() != null && this.getCurrentFocus().getWindowToken() != null) {
            systemService.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }

        return super.onTouchEvent(event);
    }
}
