package br.imobox.com.imobox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.imobox.com.imobox.helper.DownloadImageTask;
import br.imobox.com.imobox.utils.Constants;

public class InfoPropertieActivity extends AppCompatActivity {

    private TextView tv_title, tv_type, tv_price, tv_additional, tv_typeImo, tv_info;
    private ImageView image;
    private Button btn_interest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_propertie);

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        String title = Constants.title[Integer.parseInt(id)];
        String type = Constants.type[Integer.parseInt(id)];
        String price = Constants.price[Integer.parseInt(id)];
        String additional = Constants.additional[Integer.parseInt(id)];
        String typeImo = Constants.typeImo[Integer.parseInt(id)];
        String info = Constants.info[Integer.parseInt(id)];
        String link = Constants.link[Integer.parseInt(id)];

        tv_title = findViewById(R.id.title);
        tv_type = findViewById(R.id.type);
        tv_price = findViewById(R.id.price);
        tv_additional = findViewById(R.id.additional);
        tv_typeImo = findViewById(R.id.typeImo);
        tv_info = findViewById(R.id.info);

        tv_title.setText(title);
        tv_price.setText(price);
        tv_additional.setText(additional);
        tv_type.setText(type);
        tv_typeImo.setText(typeImo);
        tv_info.setText(info);

        image = findViewById(R.id.image);

        btn_interest = findViewById(R.id.btn_interest);

        btn_interest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(InfoPropertieActivity.this, CHATCLASS.class);
//                startActivity(intent);
            }
        });

        new DownloadImageTask(image).execute(link);
    }
}
