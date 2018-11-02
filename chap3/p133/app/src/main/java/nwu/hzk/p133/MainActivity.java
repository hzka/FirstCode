package nwu.hzk.p133;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msglist = new ArrayList<>();
    private EditText input_Text;
    private Button btn_send;
    private RecyclerView msgrecyclerview;
    private MsgAdapter msgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMessages();
        input_Text = (EditText) findViewById(R.id.input_text);
        btn_send = (Button) findViewById(R.id.send_btn);
        msgrecyclerview = (RecyclerView) findViewById(R.id.msg_recycler);
        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
        msgrecyclerview.setLayoutManager(layoutmanager);
        msgAdapter = new MsgAdapter(msglist);
        msgrecyclerview.setAdapter(msgAdapter);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = input_Text.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.Type_Sent);
                    msglist.add(msg);
                    msgAdapter.notifyItemInserted(msglist.size()-1);
                    //当有新消息时，刷新RecyclerView中显示
                    msgrecyclerview.scrollToPosition(msglist.size()-1);
                    //将recyclerview定位至最后一行
                    input_Text.setText("");
                }
            }
        });
    }

    private void initMessages() {
        Msg msg01 = new Msg("Hello,guy",Msg.Type_Sent);
        msglist.add(msg01);
        Msg msg02 = new Msg("Hello,who is that?",Msg.Type_Received);
        msglist.add(msg02);
        Msg msg03 = new Msg("kevinhe",Msg.Type_Sent);
        msglist.add(msg03);
    }
}
