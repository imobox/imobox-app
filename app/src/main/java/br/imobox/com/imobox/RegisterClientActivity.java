package br.imobox.com.imobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class RegisterClientActivity extends AppCompatActivity {

    Button btn_add;

    TextView et_email,et_perfil,et_about,et_birthday,et_school_records,et_work_records,et_location;
    RadioButton male,female,rent,purchase;
    Spinner sppiner_what_are_you_looking_for, sppiner_why_do_you_want_to_rent_buy_moment_of_life;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        btn_add = findViewById(R.id.btn_add);

        // TextView
        et_email = findViewById(R.id.et_email);
        et_perfil = findViewById(R.id.et_perfil);
        et_about = findViewById(R.id.et_about);
        et_birthday = findViewById(R.id.et_birthday);
        et_school_records = findViewById(R.id.et_school_records);
        et_work_records = findViewById(R.id.et_work_records);
        et_location = findViewById(R.id.et_location);

        // RadioButton
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        rent = findViewById(R.id.rent);
        purchase = findViewById(R.id.purchase);

        // Spinner
        sppiner_what_are_you_looking_for = findViewById(R.id.sppiner_what_are_you_looking_for);
        sppiner_why_do_you_want_to_rent_buy_moment_of_life = findViewById(R.id.sppiner_why_do_you_want_to_rent_buy_moment_of_life);

        // ProgressBar
        progressbar = findViewById(R.id.progressbar);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterClientActivity.this, ListPurchasePropertiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
