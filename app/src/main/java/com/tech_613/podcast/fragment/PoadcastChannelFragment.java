package com.tech_613.podcast.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.ui.activity.PodcastChannelActivity;
import com.tech_613.podcast.utils.PreferenceManager;

public class PoadcastChannelFragment extends Fragment implements View.OnClickListener {
    private LinearLayout lin_click1,lin_click2;
    private View view1,view2;
    private TextView txt_local,txt_global;
    private LinearLayout image_arrow;
    public static PoadcastChannelFragment newInstance(){
        PoadcastChannelFragment poadcastChannelFragment=new PoadcastChannelFragment();
        return poadcastChannelFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=null;
        if(PreferenceManager.getThem()==1){
            view=inflater.inflate(R.layout.podcastlist_dark_activity,container,false);
        }
        else {
            view=inflater.inflate(R.layout.activity_channel,container,false);
        }
        initXml(view);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, EpisodeFragment.newInstance()).addToBackStack("tag").commit();
        return view;
    }

    public void initXml(View view){
        lin_click1=(LinearLayout)view.findViewById(R.id.relative1);
        lin_click1.setOnClickListener(this);
        lin_click2=(LinearLayout)view.findViewById(R.id.relative2);
        lin_click2.setOnClickListener(this);
        view1=(View)view.findViewById(R.id.view1);
        view2=(View)view.findViewById(R.id.view2);
        txt_local=view.findViewById(R.id.local);
        txt_global=view.findViewById(R.id.global);
        image_arrow=view.findViewById(R.id.imageView15);
        image_arrow.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.relative1:
                view1.setVisibility(View.VISIBLE);
                txt_local.setAlpha((float) 0.8);
                txt_global.setAlpha((float) 0.5);
                view2.setVisibility(View.INVISIBLE);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, EpisodeFragment.newInstance()).addToBackStack("tag").commit();
                break;
            case R.id.relative2:
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                txt_global.setAlpha((float) 0.8);
                txt_local.setAlpha((float) 0.5);
                FragmentTransaction transaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.container, AboutFragment.newInstance()).addToBackStack("tag").commit();

                break;
            case R.id.imageView15:
                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();
                break;

        }
    }
}
