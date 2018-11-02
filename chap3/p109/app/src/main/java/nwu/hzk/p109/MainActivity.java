package nwu.hzk.p109;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();//获得ActionBar的实例
        if(actionBar!=null){
            actionBar.hide();//将标题栏隐藏起来
        }
    }
}
