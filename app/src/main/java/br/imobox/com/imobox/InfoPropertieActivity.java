package br.imobox.com.imobox;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import br.imobox.com.imobox.helper.DownloadImageTask;
import br.imobox.com.imobox.utils.Constants;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InfoPropertieActivity extends AppCompatActivity {

    private TextView tv_title, tv_type, tv_price, tv_additional, tv_typeImo, tv_info;
    private ImageView image;
    private Button btn_interest;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient client = new OkHttpClient();

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
                sendNotification();
            }
        });

        new DownloadImageTask(image).execute(link);
    }

    private void sendNotification() {
         new MessageTask().execute();
    }

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "key=AAAAIK2r3WQ:APA91bG26wbRG_BOo9OPdNaa6i5RsGw-HflcXUYtSF3NQTWfq2-eODzfKTl6pPADborxs_9DDeQFTCLg9Dt8SiWRy0E1r5Fdl_1PR-VXDmKMgH2BkFKY-rqqlJ8ArXmSF5uKrgTFrgR1")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    class MessageTask extends AsyncTask<Void, Void, Void> {

        private Exception exception;

        protected void onPostExecute() {
            // TODO: check this.exception
            // TODO: do something with the feed
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                post("https://fcm.googleapis.com/fcm/send", "{\"to\": \"/topics/corretor\",\n" +
                        "  \"data\": {\n" +
                        "    \"message\": \"Posso ajudar?\"\n" +
                        "   }}");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
