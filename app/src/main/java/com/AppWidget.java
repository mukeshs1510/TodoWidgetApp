package com;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import com.mbs.todowidgetapp.MainActivity;
import com.mbs.todowidgetapp.R;

public class AppWidget extends AppWidgetProvider {
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for(int appWidgetid: appWidgetIds) {
            Intent intent = new Intent(context, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_main);
            remoteViews.setOnClickPendingIntent(R.id.tvWidget, pendingIntent);
            appWidgetManager.updateAppWidget(appWidgetid, remoteViews);
        }
    }
}
