package nwu.hzk.p122;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hzk on 2018/10/30.
 */

//1.新建适配器继承自RecyclerView.Adapter，泛型指定为自己的ViewHolder
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitList;

    public class ViewHolder extends RecyclerView.ViewHolder {
        View fruitview;
        ImageView fruitImage;
        TextView fruitName;

        //4.ViewHolder构造函数传递进入View参数，通过findViewById获取ImageView和TextView的实例；
        public ViewHolder(View itemView) {
            super(itemView);
            fruitview = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            fruitName = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
    //2.FruitAdapter构造函数中将要展示的数据源传递给全局变量；
    public FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }

    //3.onCreateViewHolder目的是创建ViewHolder实例，将fruit_item传递进来，创建ViewHolder实例，
    // 将加载的布局传递至构造函数ViewHolder中去。
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"you clicked the view "+fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });
        viewHolder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"you clicked the Image "+fruit.getName(),Toast.LENGTH_LONG).show();
            }
        });
        return viewHolder;
    }

    //5.onBindViewHolder目的是每个子项滚动到屏幕内的时候执行，通过poistion获取位置，然后set进去。
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    //6.getItemCount告诉我们一共有多少子项
    @Override
    public int getItemCount() {
        return mFruitList.size();
    }


}
