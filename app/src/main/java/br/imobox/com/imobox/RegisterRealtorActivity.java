package br.imobox.com.imobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterRealtorActivity extends AppCompatActivity {

    Button btn_add;

    EditText creci;
    Spinner tipo_imovel,regioes, disponibilidade, preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_realtor);

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                Intent intent = new Intent(RegisterRealtorActivity.this, ListKnownPropertiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
