package nwu.hzk.p145;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hzk on 2018/10/31.
 */

public class LeftFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //将刚才写的布局动态加载进来。
        View view = inflater.inflate(R.layout.left_fragmet,container,false);
        return view;
    }
}
