package nwu.hzk.p77;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_01;
    private EditText editText_01;
    private ImageView imageView_01;
    private ProgressBar progressBar_01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_01 = (Button) findViewById(R.id.button_01);
        editText_01 = (EditText) findViewById(R.id.edit_text);
        imageView_01 = (ImageView) findViewById(R.id.image_view);
        progressBar_01 = (ProgressBar) findViewById(R.id.progress_bar);
//        btn_01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"hello Button",Toast.LENGTH_SHORT).show();
//            }
//        });
        btn_01.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_01:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("this is a ProgreeDialog");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                //AlertDialog简单用法
//                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
//                dialog.setTitle("This is an Dialog");
//                dialog.setMessage("something important!");
//                dialog.setCancelable(false);//该弹窗不可取消
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this,"OK",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
//                    }
//                });
//                dialog.show();
                //progressBar简单用法
//                int progress = progressBar_01.getProgress();
//                progress+=10;
//                progressBar_01.setProgress(progress);
//                if(progressBar_01.getVisibility() == View.GONE){
//                    progressBar_01.setVisibility(View.VISIBLE);
//                }else{
//                    progressBar_01.setVisibility(View.GONE);
//                }
                //imageView简单用法
//                imageView_01.setImageResource(R.drawable.second);
                //Edittext简单用法
//                String inputText = editText_01.getText().toString();
//                Toast.makeText(MainActivity.this,inputText,Toast.LENGTH_SHORT).show();
//                Toast.makeText(MainActivity.this,"hello Button",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;

        }
    }
}
