package com.ztrey.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;

public class Notification_receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent repeating_intent = new Intent(context,MainActivity.class); //previously had Repeating_activity.class as the second argument
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(
                context,
                1,
                repeating_intent,
                PendingIntent.FLAG_UPDATE_CURRENT //setting mutability flag
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notify_001");
        builder.setSmallIcon(R.drawable.ic_mma_glove); //TODO - find another icon (other than android.R.drawable.arrow_up_float)
        builder.setAutoCancel(true);
        //builder.setOngoing(true);
        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.build().flags = Notification.FLAG_NO_CLEAR | Notification.PRIORITY_HIGH;
        builder.setContentTitle("Martial Arts Quotes");
        builder.setContentText("Tap to view the quote of the day");
        builder.setContentIntent(pendingIntent);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelID = "channel_id";
            NotificationChannel channel = new NotificationChannel(channelID,"Quote of the day",NotificationManager.IMPORTANCE_HIGH);
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
            builder.setChannelId(channelID);
        }

        Notification notification = builder.build();
        notificationManager.notify(1,notification);
    }
}
