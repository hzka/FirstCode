package nwu.hzk.p185;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BasicActivity {
    private EditText account_edit;
    private EditText password_edit;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account_edit = (EditText) findViewById(R.id.account);
        password_edit = (EditText) findViewById(R.id.password);
        login_btn = (Button) findViewById(R.id.login);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = account_edit.getText().toString();
                String password = password_edit.getText().toString();
                if(account.equals("admin")&&password.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"invalid",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
