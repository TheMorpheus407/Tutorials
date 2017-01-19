package com.example.morpheus.applauncher;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PackageManager packageManager;
    private List<myApps> meineApps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        packageManager = getPackageManager();
        meineApps = new ArrayList<myApps>();
        Intent i = new Intent(Intent.ACTION_MAIN, null);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> apps = packageManager.queryIntentActivities(i, 0);
        for (ResolveInfo r: apps)
        {
            myApps app = new myApps(r.activityInfo.loadIcon(packageManager), r.loadLabel(packageManager), r.activityInfo.packageName);
            meineApps.add(app);
        }
        ListView listView = (ListView)findViewById(R.id.alleapps);
        ArrayAdapter<myApps> adapter = new ArrayAdapter<myApps>(this, R.layout.listelement, meineApps){

            @Override
            public View getView(int pos, View convertView, ViewGroup parent)
            {
                if(convertView == null)
                    convertView = getLayoutInflater().inflate(R.layout.listelement, null);
                ImageView icon = (ImageView)convertView.findViewById(R.id.appicon);
                icon.setImageDrawable(meineApps.get(pos).icon);

                TextView text = (TextView) convertView.findViewById(R.id.app_name);
                text.setText(meineApps.get(pos).name);
                return convertView;
            }
        };
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                Intent i = packageManager.getLaunchIntentForPackage(meineApps.get(pos).packagename.toString());
                MainActivity.this.startActivity(i);
            }
        });
    }


    public class myApps{
        Drawable icon;
        CharSequence name;
        CharSequence packagename;
        public myApps(Drawable icon, CharSequence name, CharSequence packagename)
        {
            this.icon = icon;
            this.name = name;
            this.packagename = packagename;
        }
    }
}
