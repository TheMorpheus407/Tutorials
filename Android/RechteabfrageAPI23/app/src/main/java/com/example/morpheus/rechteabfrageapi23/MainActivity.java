package com.example.morpheus.rechteabfrageapi23;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String myPermission = Manifest.permission.WRITE_CALENDAR;
    public static final int myRequestCode = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showPermission();
        requestPermission();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults)
    {
        switch (requestCode){
            case myRequestCode:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(this, "permission just granted", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(this, "permission just denied", Toast.LENGTH_LONG).show();
                }
        }
    }

    private void requestPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, myPermission);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, myPermission)){
            //zeige Erklärung an.
        }
        ActivityCompat.requestPermissions(this, new String[]{myPermission}, myRequestCode);
    }

    private void showPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(this, myPermission);
        if(permissionCheck == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "permission granted", Toast.LENGTH_LONG).show();
        }
        if(permissionCheck == PackageManager.PERMISSION_DENIED)
        {
            Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
        }
    }
}
