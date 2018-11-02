package nwu.hzk.p177;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_01;
    private IntentFilter intentFilter_01;
    private LocalBroadcastManager localBroadcastManager;
    private BroadCastreciver localbroadCastreciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_01 = (Button) findViewById(R.id.btn_01);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("nwu.hzk.p177.My_broad");
////                sendBroadcast(intent);
//                sendOrderedBroadcast(intent,null);
                localBroadcastManager.sendBroadcast(intent);//发送
            }
        });
        intentFilter_01 = new IntentFilter();
        intentFilter_01.addAction("nwu.hzk.p177.My_broad");
        localbroadCastreciver = new BroadCastreciver();
        localBroadcastManager.registerReceiver(localbroadCastreciver,intentFilter_01);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(localbroadCastreciver);
    }

    public class BroadCastreciver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"received local broad ",Toast.LENGTH_LONG).show();
        }
    }
}
