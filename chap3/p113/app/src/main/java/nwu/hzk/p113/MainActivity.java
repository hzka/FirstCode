package nwu.hzk.p113;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //1.提供数据
    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear",
            "Grapte","Apple","Banana","Orange","Watermelon","Pear"
            ,"Grapte","Apple","Banana","Orange","Watermelon","Pear","Grapte"};

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2.构建适配器，目的是传递数据进入ListView，适配器是ArrayAdapter，可以通过泛型传递数据。
        //android.R.layout.simple_list_item_1里面只有一个简单的TextView。
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
//                android.R.layout.simple_list_item_1,data);
//        ListView listView_01 = (ListView) findViewById(R.id.list_view);
        //3.setAdapter将适配器传递进去，完成Listview与数据的关联。
//        listView_01.setAdapter(adapter);
        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);
        ListView listView_01 = (ListView) findViewById(R.id.list_view);
        //3.setAdapter将适配器传递进去，完成Listview与数据的关联。
        listView_01.setAdapter(adapter);

        listView_01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fruit fruit = fruitList.get(i);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
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
