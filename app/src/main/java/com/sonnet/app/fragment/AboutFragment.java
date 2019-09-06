package com.tech_613.podcast.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.utils.PreferenceManager;

public class AboutFragment extends Fragment {

    private ConstraintLayout about_layout;
    private TextView txt_idea,txt_author;
    public static AboutFragment newInstance(){

        AboutFragment aboutFragment=new AboutFragment();
        return aboutFragment;
    }

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_about,container,false);
        about_layout=view.findViewById(R.id.about_background);
        txt_author=view.findViewById(R.id.textView48);
        txt_idea=view.findViewById(R.id.textView47);
        if(PreferenceManager.getThem()==1)
        {
            about_layout.setBackgroundResource(R.color.dark);
            txt_idea.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));
            txt_author.setTextColor(ContextCompat.getColor(getActivity(),R.color.white));


        }
        else {
            about_layout.setBackgroundResource(R.color.background);
            txt_idea.setTextColor(R.color.dark);
            txt_author.setTextColor(R.color.dark);
        }
        return view;
    }
}
