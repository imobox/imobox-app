package br.imobox.com.imobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.messaging.FirebaseMessaging;

import br.imobox.com.imobox.handler.DatabaseHandler;
import br.imobox.com.imobox.handler.DatabaseRealtorHandler;
import br.imobox.com.imobox.model.Client;
import br.imobox.com.imobox.model.Realtor;

public class RegisterRealtorActivity extends AppCompatActivity {

    Button btn_add;

    EditText creci;
    Spinner tipo_imovel,regioes, disponibilidade, preferencia;

    DatabaseRealtorHandler db;

    String tx_creci;
    String tx_tipo_imovel;
    String tx_disponibilidade;
    String tx_preferencia;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_realtor);

        creci = findViewById(R.id.creci);
        tipo_imovel = findViewById(R.id.tipo_imovel);
        regioes = findViewById(R.id.regioes);
        disponibilidade = findViewById(R.id.disponibilidade);
        preferencia = findViewById(R.id.preferencia);

        db = new DatabaseRealtorHandler(this);


        if(db.getRealtorCounts() > 0) {
            Realtor realtor = db.getRealtor(1);

            id = realtor.getId();
            tx_creci = realtor.getCreci();
            tx_tipo_imovel = realtor.getTipoImovel();
            tx_disponibilidade = realtor.getDisponibilidade();
            tx_preferencia = realtor.getPreferencia();

            creci.setText(tx_creci);
            tipo_imovel.setSelection(Integer.parseInt(tx_tipo_imovel));
            disponibilidade.setSelection(Integer.parseInt(tx_disponibilidade));
            preferencia.setSelection(Integer.parseInt(tx_preferencia));
        }

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseMessaging.getInstance().subscribeToTopic("corretor");
                tx_creci = creci.getText().toString();
                tx_tipo_imovel = String.valueOf(tipo_imovel.getSelectedItemId());
                tx_disponibilidade = String.valueOf(disponibilidade.getSelectedItemId());
                tx_preferencia = String.valueOf(preferencia.getSelectedItemId());

                if(db.getRealtorCounts() > 0) {
                    db.updateRealtor(new Realtor(id, tx_creci, tx_tipo_imovel, tx_disponibilidade, tx_preferencia));
                    onResume();
                } else {
                    db.addRealtor(new Realtor(tx_creci, tx_tipo_imovel, tx_disponibilidade, tx_preferencia));
                    onResume();
                }

                Intent intent = new Intent(RegisterRealtorActivity.this, ListKnownPropertiesActivity.class);
                startActivity(intent);
            }
        });
    }
}
