package com.aftabmaner27.implementnotificationsinandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String CHANEL_ID = "My chanel";
    private static final int NOTIFICATION_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.logo, null);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap largeicon = bitmapDrawable.getBitmap();

        Notification notification;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.logo)
                    .setSubText("New massage from Aftab")
                    .setContentText("New Massage")
                    .setChannelId(CHANEL_ID)
                    .build();

            nm.createNotificationChannel(new NotificationChannel(CHANEL_ID, "New chanel", NotificationManager.IMPORTANCE_HIGH));
        } else {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.logo)
                    .setSubText("New massage from Aftab")
                    .setContentText("New Massage")
                    .build();

        }
        nm.notify(NOTIFICATION_ID, notification);
    }
}