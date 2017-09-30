package com.developers.shreeganesha.ranazunjardholtasha;

import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Shree Ganesha on 6/2/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public static final String TAG = "MyFirebaseMessagingService";


    @SuppressLint("LongLogTag")
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"From"+remoteMessage.getFrom());
        if (remoteMessage.getData() != null){

            Log.d(TAG,"Messagedata"+remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null){


            sendNotification(remoteMessage.getNotification().getBody());

        }
    }

    private void sendNotification(String body) {

        Intent intent = new Intent(this,Notification.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        Uri notificationSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);

        //Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        //long[] pattern ={0, 100 , 1000};


        long[] vibrate = {1000,1000,1000,1000,1000};
        notification.setSmallIcon(R.drawable.developer)
                .setSound(notificationSound)
               .setVibrate(vibrate)
                .setContentText("Hiii")
                .setContentTitle("Notify")
                .setAutoCancel(true)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification.build());
    }
}
