package com.bigggfish.rongcloudimdemo;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import io.rong.imkit.RongIM;

public class CommentMsgActivity extends FragmentActivity {

    private Button btnChat1;
    private Button btnChat2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment_msg);

    /*    findViewById(R.id.btn_chat1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startPrivateChat(CommentMsgActivity.this, "1", "单聊");
            }
        });

        findViewById(R.id.btn_chat2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startPrivateChat(CommentMsgActivity.this, "1", "单聊");
            }
        });*/

    }
}
