package br.imobox.com.imobox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn_client, btn_realtor, btn_owner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_client  = findViewById(R.id.btn_client);
        btn_realtor = findViewById(R.id.btn_realtor);
        btn_owner   = findViewById(R.id.btn_owner);


    }
}
