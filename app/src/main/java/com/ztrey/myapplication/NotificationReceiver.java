package com.ztrey.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Intent repeating_intent = new Intent(context,MainActivity.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            pendingIntent = PendingIntent.getActivity(context,0,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);
        } else {
            pendingIntent = PendingIntent.getActivity(context, 0, repeating_intent, PendingIntent.FLAG_UPDATE_CURRENT);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"quoteOfDay");
        builder.setSmallIcon(R.drawable.ic_mma_glove);
        builder.setContentTitle("Martial Arts Quotes");
        builder.setContentText("Tap to view the quote of the day");
        builder.setAutoCancel(true);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.build().flags = Notification.FLAG_NO_CLEAR | Notification.PRIORITY_HIGH;
        builder.setContentIntent(pendingIntent);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123,builder.build());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelID = "quoteOfDay";
            NotificationChannel channel = new NotificationChannel(channelID,"Quote of the day",NotificationManager.IMPORTANCE_HIGH);
            channel.enableVibration(true);

            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelID);
        }

    }
}
