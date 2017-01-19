package com.example.morpheus.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    String SrcPath = Environment.getExternalStorageDirectory() + "/storage/emulated/0/Movies/AndroidTutorial.mp4";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoView myVideoView = (VideoView)findViewById(R.id.videoView);
        myVideoView.setVideoPath(SrcPath);
        myVideoView.setMediaController(new MediaController(this));
        myVideoView.requestFocus();
        myVideoView.start();
    }
}
//"/storage/emulated/0/Movies/Android Tutorial #1.1 - Installation von Android Studio auf Linux.mp4"