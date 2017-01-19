package com.example.morpheus.notificationservice;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class Notifier extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_TIMER = "com.example.morpheus.notificationservice.action.TIMER";
    public static ArrayList<String> events = new ArrayList<String>();

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.morpheus.notificationservice.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.morpheus.notificationservice.extra.PARAM2";

    public Notifier() {
        super("Notifier");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startTimer(Context context, String param1, String param2) {
        Intent intent = new Intent(context, Notifier.class);
        intent.setAction(ACTION_TIMER);
        //falls du params brauchst, ich wüsste aber nicht welche
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    public static void listenToNewEvent(String event)
    {
        events.add(event);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_TIMER.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionTimer();
            }
        }
    }

    private void handleActionTimer() {
        //Datum vergleichen und falls fällig - zB 1h früher - dann pushen
        while(true){
            try {
                //hier muss du durch die Events durchschleifen und überprüfen, ob eins nahe ist. Falls ja - generiere eine Notification und WICHTIG: LÖSCHE ES AUS DER LISTE!!!
                //Achtung: Du musst immer die ganze Schleife prüfen, die sind ja nicht zeitlich geordnet.
                boolean eventIsNear = true;
                if(eventIsNear) {
                    //Params aus Liste ziehen!
                    notificationGenerator(timeOfEvent, eventName);
                }
                //schläft 5 Minuten - muss ja nicht genauer sein, eventuell sogar noch länger machen, um Batterie zu sparen.
                Thread.sleep(5*60*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void notificationGenerator(String param1, String param2)
    {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);
        //Icon fehlt mir
        Notification n  = new Notification.Builder(this).
                setContentTitle("Event startet um " + param1)
                .setContentText("EventName aus Param2?")
                        .setContentIntent(pIntent)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.icon)
                        .addAction(R.drawable.icon, "Call", pIntent)
                        .addAction(R.drawable.icon, "More", pIntent).build();


        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, n);
    }
}
