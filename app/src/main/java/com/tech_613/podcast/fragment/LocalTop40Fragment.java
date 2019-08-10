package com.tech_613.podcast.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tech_613.podcast.R;

public class LocalTop40Fragment extends Fragment {


    public static LocalTop40Fragment newInstance(){
        LocalTop40Fragment localTop40Fragment=new LocalTop40Fragment();
        return localTop40Fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_local,container,false);
        return view;
    }

}
