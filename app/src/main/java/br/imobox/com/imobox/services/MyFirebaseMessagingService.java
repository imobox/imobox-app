package br.imobox.com.imobox.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import br.imobox.com.imobox.ChatActivity;
import br.imobox.com.imobox.MainActivity;
import br.imobox.com.imobox.R;

/**
 * Created by Wilder on 15/11/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());


        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

            Intent intent = new Intent(this, ChatActivity.class);

            PendingIntent pi = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);
            intent.setAction(Long.toString(System.currentTimeMillis()));

            NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background) // notification icon
                    .setContentTitle("Match com um novo cliente!") // title for notification
                    .setContentText("Está interessado?") // message for notification
                    .addAction(R.drawable.ic_launcher_background, "sim", pi)
                    .addAction(R.drawable.com_facebook_tooltip_black_xout, "Não", null);
                    //.setAutoCancel(true); // clear notification after click remoteMessage.getData().values().toArray()[0]
            mBuilder.setContentIntent(pi);

            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());
        } else if (remoteMessage.getData() != null) {
            Intent intent = new Intent(this, ChatActivity.class);

            PendingIntent pi = PendingIntent.getActivity(this,0,intent, PendingIntent.FLAG_ONE_SHOT);
            intent.setAction(Long.toString(System.currentTimeMillis()));

            NotificationCompat.Builder mBuilder =   new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background) // notification icon
                    .setContentTitle("Match com um novo cliente!") // title for notification
                    .setContentText("Está interessado?") // message for notification
                    .addAction(R.drawable.ic_launcher_background, "sim", pi)
                    .addAction(R.drawable.com_facebook_tooltip_black_xout, "Não", null);
            //.setAutoCancel(true); // clear notification after click remoteMessage.getData().values().toArray()[0]
            mBuilder.setContentIntent(pi);

            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
}
