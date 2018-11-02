package nwu.hzk.p122;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recycler_view01);
        //指明RecyclerView为LinearLayoutManager线性布局方式；
//        LinearLayoutManager layoutmanager = new LinearLayoutManager(this);
//        layoutmanager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager layoutmanager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutmanager);
        //将构建的适配器放入recyclerview中去
        FruitAdapter fruitadapter = new FruitAdapter(fruitList);
        recyclerview.setAdapter(fruitadapter);
    }

    private void initFruits() {
        for(int i = 0;i<7;i++){
            Fruit apple = new Fruit("Apple",R.drawable.second);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana",R.drawable.timg);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange",R.drawable.second);
            fruitList.add(orange);
        }
    }
}
