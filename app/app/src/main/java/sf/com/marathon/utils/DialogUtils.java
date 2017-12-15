package sf.com.marathon.utils;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

import sf.com.marathon.R;

public class DialogUtils {

    public interface OnClickYesListener {
        void onClickYes();
    }

    public interface OnClickNoListener {
        void onClickNo();
    }

    public static void showQuestionDialog(Context context, String title,
                                          String text, final OnClickYesListener listenerYes,
                                          final OnClickNoListener listenerNo) {
        Builder builder = new AlertDialog.Builder(context);

        if (StringUtils.isNotEmpty(text)) {
            // 此方法为dialog写布局
            final TextView textView = new TextView(context);
            textView.setText(text);
            LinearLayout layout = new LinearLayout(context);
            layout.setPadding(10, 0, 10, 0);
            layout.addView(textView, new LayoutParams(LayoutParams.FILL_PARENT,
                    LayoutParams.WRAP_CONTENT));
            builder.setView(layout);
        }
        // 设置title
        builder.setTitle(title);
        // 设置确定按钮，固定用法声明一个按钮用这个setPositiveButton
        builder.setPositiveButton(context.getString(R.string.yes),
                new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 如果确定被电击
                        if (listenerYes != null) {
                            listenerYes.onClickYes();
                        }
                    }
                });
        // 设置取消按钮，固定用法声明第二个按钮要用setNegativeButton
        builder.setNegativeButton(context.getString(R.string.no),
                new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // 如果取消被点击
                        if (listenerNo != null) {
                            listenerNo.onClickNo();
                        }
                    }
                });

        // 控制这个dialog可不可以按返回键，true为可以，false为不可以
        builder.setCancelable(false);
        // 显示dialog
        builder.create().show();
    }
}