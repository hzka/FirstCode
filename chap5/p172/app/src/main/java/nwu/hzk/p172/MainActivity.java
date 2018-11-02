package nwu.hzk.p172;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.创建intentFilter实例，添加一个action的值，广播接收器想接受什么广播，在这里添加相应的Actiona:一定要确定对应的Action，android.net.conn.CONNECTIVITY_CHANGE
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        //3.创建NetworkChangeReceiver实例，调用registerReceiver来进行注册，实现动态监听功能。
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
    }
    //7.动态注册的广播一定要取消注册才行。unregisterReceiver注销广播。
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
    }

    //1.定义内部类，继承自BroadcastReceiver，并重写父类onReceive方法，创建广播接收器。
    public class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
//            Toast.makeText(context,"network changes",Toast.LENGTH_LONG).show();
            //4.ConnectivityManager管理网络服务系统服务类，通过getSystemService获得该实例,getActiveNetworkInfo获取networkInfo实例。
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            //5.通过networkInfo的isAvailable判断当前是否有网络。
            if(networkInfo!=null && networkInfo.isAvailable()){
                Toast.makeText(context,"network is available",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(context,"network is unavaliable",Toast.LENGTH_LONG).show();
            }
            //6.一定要在AndroidMAnifest.xml中设置权限声明。
//            <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
        }
    }
}
