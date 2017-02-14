package com.bigggfish.rongcloudimdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import io.rong.imkit.RongIM;
import io.rong.imlib.NativeObject;
import io.rong.imlib.RongIMClient;

public class MainActivity extends AppCompatActivity {

    //测试信息 "code":200,"userId":"1",
    // "token":"LpFznHEaugFFQgfiDz4APrAtf/1o9CeLoZs9/0j/GORaaihJlFLzolwFD0NCOzT+I6AMMYlsDysTJDKt1Iw3OA=="

    //{"code":200,"userId":"2",
    // "token":"U8JUDm9yHZr+nKSXKy+GqLAtf/1o9CeLoZs9/0j/GORaaihJlFLzoglwtwRXbfNzzfs2MWv+yIMTJDKt1Iw3OA=="}

    private static final String tokenOf1 = "LpFznHEaugFFQgfiDz4APrAtf/1o9CeLoZs9/0j/GORaaihJlFLzolwFD0NCOzT+I6AMMYlsDysTJDKt1Iw3OA==";
    private static final String tokenOf2 = "U8JUDm9yHZr+nKSXKy+GqLAtf/1o9CeLoZs9/0j/GORaaihJlFLzoglwtwRXbfNzzfs2MWv+yIMTJDKt1Iw3OA==";
    private String otherUserId = "1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_connect).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect(tokenOf1);
                otherUserId = "2";
            }
        });

        findViewById(R.id.btn_connect2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connect(tokenOf2);
                otherUserId = "1";
            }
        });

        findViewById(R.id.btn_list).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CommentListActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_comment1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RongIM.getInstance().startPrivateChat(MainActivity.this, otherUserId, "单聊");
               /* Intent intent = new Intent(MainActivity.this, CommentMsgActivity.class);
                startActivity(intent);*/
            }
        });

    }

    /**
     * <p>连接服务器，在整个应用程序全局，只需要调用一次，需在 init(Context) 之后调用。</p>
     * <p>如果调用此接口遇到连接失败，SDK 会自动启动重连机制进行最多10次重连，分别是1, 2, 4, 8, 16, 32, 64, 128, 256, 512秒后。
     * 在这之后如果仍没有连接成功，还会在当检测到设备网络状态变化时再次进行重连。</p>
     *
     * @param token    从服务端获取的用户身份令牌（Token）。
     * @return RongIM  客户端核心类的实例。
     */
    private void connect(String token) {

        if (getApplicationInfo().packageName.equals(MApplicaition.getCurProcessName(getApplicationContext()))) {

            RongIM.connect(token, new RongIMClient.ConnectCallback() {

                /**
                 * Token 错误。可以从下面两点检查 1.  Token 是否过期，如果过期您需要向 App Server 重新请求一个新的 Token
                 *                  2.  token 对应的 appKey 和工程里设置的 appKey 是否一致
                 */
                @Override
                public void onTokenIncorrect() {

                }

                /**
                 * 连接融云成功
                 * @param userid 当前 token 对应的用户 id
                 */
                @Override
                public void onSuccess(String userid) {
                    Log.d("LoginActivity", "--onSuccess" + userid);
                    Toast.makeText(MainActivity.this, "connect success", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    //finish();
                }

                /**
                 * 连接融云失败
                 * @param errorCode 错误码，可到官网 查看错误码对应的注释
                 */
                @Override
                public void onError(RongIMClient.ErrorCode errorCode) {

                }
            });
        }
    }

/*
    *//**
     * <p>启动会话界面。</p>
     * <p>使用时，可以传入多种会话类型 {@link io.rong.imlib.model.Conversation.ConversationType} 对应不同的会话类型，开启不同的会话界面。
     * 如果传入的是 {@link io.rong.imlib.model.Conversation.ConversationType#CHATROOM}，sdk 会默认调用
     * {@link RongIMClient#joinChatRoom(String, int, RongIMClient.OperationCallback)} 加入聊天室。
     * 如果你的逻辑是，只允许加入已存在的聊天室，请使用接口 {@link #startChatRoomChat(Context, String, boolean)} 并且第三个参数为 true</p>
     *
     * @param context          应用上下文。
     * @param conversationType 会话类型。
     * @param targetId         根据不同的 conversationType，可能是用户 Id、讨论组 Id、群组 Id 或聊天室 Id。
     * @param title            聊天的标题，如果传入空值，则默认显示会话的名称。
     *//*
    public void startConversation(Context context, Conversation.ConversationType conversationType, String targetId, String title)

    *//**
     * 启动会话列表界面。
     *
     * @param context               应用上下文。
     * @param supportedConversation 定义会话列表支持显示的会话类型，及对应的会话类型是否聚合显示。
     *                              例如：supportedConversation.put(Conversation.ConversationType.PRIVATE.getName(), false) 非聚合式显示 private 类型的会话。
     *//*
    public void startConversationList(Context context, Map<String, Boolean> supportedConversation)

    *//**
     * 启动聚合后的某类型的会话列表。<br> 例如：如果设置了单聊会话为聚合，则通过该方法可以打开包含所有的单聊会话的列表。
     *
     * @param context          应用上下文。
     * @param conversationType 会话类型。
     *//*
    public void startSubConversationList(Context context, Conversation.ConversationType conversationType)*/
}
