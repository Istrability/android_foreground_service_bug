package hr.istrability.foreground_service_bug;

import static android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_SHORT_SERVICE;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyForegroundService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        startForeground2();
    }

    private void startForeground2() {
        String channelId = "DoNothingChannel";

        NotificationChannel channel = new NotificationChannel(
            channelId,
            "Do Nothing Service",
            NotificationManager.IMPORTANCE_HIGH
        );
        NotificationManager manager = getSystemService(NotificationManager.class);
        manager.createNotificationChannel(channel);

        Notification notification = new Notification.Builder(this, channelId)
            .setContentTitle("Doing Nothing")
            .setContentText("This service intentionally does nothing")
            .setSmallIcon(android.R.drawable.ic_dialog_info) // Use your app icon
            .build();

        // Start foreground service (ID cannot be 0)
        startForeground(1, notification, FOREGROUND_SERVICE_TYPE_SHORT_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Keep service running
        return START_STICKY;
    }
}
