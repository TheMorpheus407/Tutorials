package com.example.morpheus.tabz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlankFragment extends Fragment {
    public static final String ARG = "parameter";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_blank, container, false);
        Bundle args = getArguments();
        String param = Integer.toString(args.getInt(BlankFragment.ARG));
        ((TextView)root.findViewById(R.id.text)).setText(param);
        return root;
    }
}
