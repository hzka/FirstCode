package nwu.hzk.p133;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hzk on 2018/10/31.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.VieHolder> {
    public List<Msg> mMsglist;
    public class VieHolder extends RecyclerView.ViewHolder{
        LinearLayout left_layout,right_layout;
        TextView left_msg,right_msg;
        public VieHolder(View itemView) {
            super(itemView);
            left_layout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            right_layout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            left_msg = (TextView) itemView.findViewById(R.id.left_msg);
            right_msg = (TextView) itemView.findViewById(R.id.right_msg);
        }
    }

    public MsgAdapter(List<Msg> msgList){
        this.mMsglist = msgList;
    }
    @Override
    public MsgAdapter.VieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        return new VieHolder(view);
    }

    @Override
    public void onBindViewHolder(MsgAdapter.VieHolder holder, int position) {
        Msg msg = mMsglist.get(position);
        if(msg.getType()==Msg.Type_Received){
            //收到消息，则显示左边布局，隐藏右边消息。
            holder.left_layout.setVisibility(View.VISIBLE);
            holder.right_layout.setVisibility(View.GONE);
            holder.left_msg.setText(msg.getContent());
        }
        if(msg.getType()==Msg.Type_Sent){
            //收到消息，则显示左边布局，隐藏右边消息。
            holder.right_layout.setVisibility(View.VISIBLE);
            holder.left_layout.setVisibility(View.GONE);
            holder.right_msg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsglist.size();
    }


}
