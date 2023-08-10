package com.example.widgetshandson;

import android.app.PendingIntent;
import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider {
    // normally we don't configure the widget in the onUpdate method,
    // other wise we do a new configuration file to host them
    // but because this is simple widget, we can do it here for now
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // iterate over all the widgets
        for (int appWidgetId : appWidgetIds) {
            // create an intent to launch the MainActivity
            Intent intent = new Intent(context, MainActivity.class);

            // create a pending intent to launch the MainActivity
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);

            // RemoveViews are responsible for creating our layouts in
            // remote processes
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.exmple_widget);
            views.setOnClickPendingIntent(R.id.app_widget_button, pendingIntent); // link the pending intent to the button


            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
