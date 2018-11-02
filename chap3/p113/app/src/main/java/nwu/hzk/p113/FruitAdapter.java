package nwu.hzk.p113;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hzk on 2018/10/30.
 */

//建立自定义适配器，继承自ArrayAdapter，泛型指定为Fruit类。
public class FruitAdapter extends ArrayAdapter<Fruit>{

    private int tvresourceId;
    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Fruit> objects) {
        //将上下文、ListView子布局的id和数据传递进来。
        super(context, resource, objects);
        tvresourceId = resource;
    }

    @NonNull
    @Override
    //每个子项滚动到屏幕内的时候会被调用。
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView == null) {
            //获取当前项的Fruit实例
            view = LayoutInflater.from(getContext()).inflate(tvresourceId, parent, false);
            viewHolder =new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitname = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);
        }else{
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        //为这个子项加载传入的布局。
//        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
//        TextView fruitname =(TextView) view.findViewById(R.id.fruit_name);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitname.setText(fruit.getName());
        //setImageResource和setText设置图片和文字。
        return view;

    }

    private class ViewHolder {
        ImageView fruitImage;
        TextView fruitname;
    }
}
