package com.example.fire;
/*

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.fire.adminSQLite.DaoDB;

import java.util.Calendar;

public class MyAlarmReceiver extends BroadcastReceiver {

    public static final int REQUEST_CODE = 12345;
    private NotificationManager notificationManager;
    private Cursor fila;
    private String alarma, titulo, descripcion;
    private final int NOTIFICATION_ID = 1010;



    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MyTestService.class);
        context.startService(i);


        //comparar fecha y hora de la db con la fecha y hora del sistema
        Calendar calendar_actual = Calendar.getInstance();
        int hora_actual, minuto_actual, dia_actual, mes_actual, anio_actual;
        String fecha_sistema, hora_sistema;

        dia_actual    = calendar_actual.get(Calendar.DAY_OF_MONTH);
        mes_actual    = calendar_actual.get(Calendar.MONTH)+1;
        anio_actual   = calendar_actual.get(Calendar.YEAR);
        hora_actual   = calendar_actual.get(Calendar.HOUR_OF_DAY);
        minuto_actual = calendar_actual.get(Calendar.MINUTE);

        fecha_sistema = dia_actual+ "-" +mes_actual+ "-" +anio_actual;
        hora_sistema  = hora_actual+ ":" +minuto_actual;

        final DaoDB daoDB = new DaoDB(context);
        SQLiteDatabase BaseDatos = daoDB.getReadableDatabase();

        if (BaseDatos!=null){
            fila = BaseDatos.rawQuery("SELECT * FROM tareas WHERE fecha='" + fecha_sistema + "' AND hora='" + hora_sistema + "'", null);
            Log.e("TAG", "LA CONSULTA: " + fila);
            if (fila.moveToFirst()){
                alarma = fila.getString(0);
                titulo = fila.getString(1);
                descripcion = fila.getString(2);
                triggerNotification(context, titulo+"\n"+descripcion);
            }
        }
        BaseDatos.close();

    }

    private void triggerNotification(Context context, String t) {

        Intent notificationIntent = new Intent(context, ScheduleActivity.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        long[] pattern = new long[]{2000, 1000, 2000};

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentIntent(contentIntent)

                .setTicker("" )
                .setContentTitle("alarma ")
                .setContentTitle("")
                .setContentText(t)
                .setContentInfo("Info")
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_notification))
                .setSmallIcon(R.drawable.ic_notification)
                .setAutoCancel(true) //Cuando se pulsa la notificación ésta desaparece
                .setSound(defaultSound)
                .setVibrate(pattern);

        Notification notificacion = new NotificationCompat.BigTextStyle(builder)
                .bigText(t)
                .setBigContentTitle("ejemplo")
                .setSummaryText("Resumen de tareas")
                .build();

        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFICATION_ID, notificacion);
    }


}
*/
