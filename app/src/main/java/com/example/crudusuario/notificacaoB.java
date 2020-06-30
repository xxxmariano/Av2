package com.example.crudusuario;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class notificacaoB extends BroadcastReceiver {
    private final static String  CHANNEL_ID = "Notificacao";
    private final int notificacaoid = 1;

    @Override
    public void onReceive(Context context, Intent intent) {



        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notificacao)
                .setContentTitle("Ja lavou sua mãos?")
                .setContentText("Lave suas mãos com frequência,use sabão e água ou um gel à base de álcool. ")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify( notificacaoid, builder.build());
    }
}
