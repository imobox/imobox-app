package br.imobox.com.imobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import br.imobox.com.imobox.handler.DatabaseHandler;
import br.imobox.com.imobox.model.Client;

public class RegisterClientActivity extends AppCompatActivity {

    Button btn_add;

    EditText et_email,et_perfil,et_about,et_birthday,et_school_records,et_work_records,et_location;
    RadioButton male,female,rent,purchase;
    Spinner sppiner_what_are_you_looking_for, sppiner_why_do_you_want_to_rent_buy_moment_of_life;
    ProgressBar progressbar;

    DatabaseHandler db;

    private String email;
    private String perfil;
    private String about;
    private String birthday;
    private String schoolRecords;
    private String workRecords;
    private String location;
    private String sex;
    private String type;
    private String lookingFor;
    private String moment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_client);

        btn_add = findViewById(R.id.btn_add);

        // EditText
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

        db = new DatabaseHandler(this);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = et_email.getText().toString();
                perfil = et_perfil.getText().toString();
                about = et_about.getText().toString();
                birthday = et_birthday.getText().toString();
                schoolRecords = et_school_records.getText().toString();
                workRecords = et_work_records.getText().toString();
                location = et_location.getText().toString();
                lookingFor = sppiner_what_are_you_looking_for.getSelectedItem().toString();
                moment = sppiner_why_do_you_want_to_rent_buy_moment_of_life.getSelectedItem().toString();
                if(rent.isChecked()) {
                    type = "R";
                } else {
                    type = "P";
                }
                if(male.isChecked()) {
                    sex = "M";
                } else {
                    sex = "F";
                }

                db.addUser(new Client(email, perfil, about, birthday, schoolRecords, workRecords, location, sex, type, lookingFor, moment));
                onResume();

                Intent intent = new Intent(RegisterClientActivity.this, ListPurchasePropertiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
