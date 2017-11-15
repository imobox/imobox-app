package br.imobox.com.imobox;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.messaging.FirebaseMessaging;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SendNotificationActivity extends AppCompatActivity {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);
        FirebaseMessaging.getInstance().subscribeToTopic("corretor");
    }

    public void sendNotification(View view) {
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
                post("https://fcm.googleapis.com/fcm/send", "{\"to\": \"/topics/news\",\n" +
                        "  \"data\": {\n" +
                        "    \"message\": \"oitoeieoieoie!\"\n" +
                        "   }}");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
