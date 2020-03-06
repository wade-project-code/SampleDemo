package com.example.sampledemo.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.RemoteViews;

import com.example.sampledemo.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String dateString = simpleDateFormat.format(new Date());

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        views.setTextViewText(R.id.mTxtId, String.valueOf(appWidgetId));
        views.setTextViewText(R.id.mTxtTime, dateString);

        int[] idArray = new int[]{appWidgetId};

        Intent intentUpdate = new Intent(context, NewAppWidget.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);

        PendingIntent pendingUpdate = PendingIntent.getBroadcast(
                context, appWidgetId, intentUpdate,
                PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.mBtnUpdate,pendingUpdate);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}

