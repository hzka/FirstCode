package nwu.hzk.p133;

/**
 * Created by hzk on 2018/10/31.
 */

public class Msg {
    public static final int Type_Received = 0;
    public static final int Type_Sent = 1;
    public String content;
    //代表消息内容
    public int type;
    //代表消息类型，有两个值可选。
    public Msg(String content,int type){
        this.content = content;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
