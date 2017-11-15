package br.imobox.com.imobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.imobox.com.imobox.model.Client;

public class MainActivity extends AppCompatActivity {
    Button btn_client, btn_realtor, btn_owner;
    Client fbClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fbClient = getIntent().getParcelableExtra("client");

        btn_client  = findViewById(R.id.btn_client);
        btn_realtor = findViewById(R.id.btn_realtor);
        btn_owner   = findViewById(R.id.btn_owner);

        btn_client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterClientActivity.class);
                intent.putExtra("client", fbClient);
                startActivity(intent);
            }
        });

        btn_realtor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterRealtorActivity.class);
                startActivity(intent);
            }
        });

        btn_owner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }
}
