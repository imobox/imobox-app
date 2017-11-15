package br.imobox.com.imobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class InfoPropertieActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_propertie);

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        

    }
}
