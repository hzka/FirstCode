package nwu.hzk.p147;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_frag= (Button) findViewById(R.id.button_01);
        btn_frag.setOnClickListener(this);
        replaceFragment(new RightFragment());
//        MainActivity activity = (MainActivity) getActivity();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_01:
                replaceFragment(new AndotherRightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment andotherRightFragment) {
        FragmentManager fragment_manager = getSupportFragmentManager();
        FragmentTransaction transaction = fragment_manager.beginTransaction();
        transaction.replace(R.id.right_frame,andotherRightFragment);
        transaction.addToBackStack(null);
        transaction.commit();

//        RightFragment rightframent = (RightFragment) getFragmentManager().findFragmentById(R.id.right_fragment);

    }
}
