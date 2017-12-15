package sf.com.marathon.widget;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import sf.com.marathon.R;

public class SignUpSuccessDialog  extends Dialog{


    private View sendView;
    private View shareView;

    public SignUpSuccessDialog(Context context) {
        super(context, R.style.CustomDialogStyle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setCancelable(true);  // 是否可以撤销
        View view = View.inflate(getContext(),R.layout.dialog_sign_up_success,null);
        setContentView(view);

        sendView = view.findViewById(R.id.sendToFriendLayout);
        shareView = view.findViewById(R.id.shareFriendCircleLayout);
    }

    public void setOnClickListener(final View.OnClickListener sendListener, final View.OnClickListener shareListener){
        if(sendView == null || shareView == null){
            return ;
        }

        sendView.setOnClickListener(sendListener);

        shareView.setOnClickListener(shareListener);
    }

}