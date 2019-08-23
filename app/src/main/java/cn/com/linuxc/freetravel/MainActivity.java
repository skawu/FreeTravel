package cn.com.linuxc.freetravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt_sign_in;
    private Button bt_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 登录界面跳转
        bt_sign_in = (Button)findViewById(R.id.bt_signin);
        bt_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(cn.com.linuxc.freetravel.MainActivity.this, MasterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // 注册界面跳转
        bt_sign_up = (Button)findViewById(R.id.bt_signup);
        bt_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(cn.com.linuxc.freetravel.MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }


}
