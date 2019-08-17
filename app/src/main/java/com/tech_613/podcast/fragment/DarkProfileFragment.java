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

import com.tech_613.podcast.R;
import com.tech_613.podcast.ui.activity.EditProfileActivity;
import com.tech_613.podcast.ui.activity.TopChatLocation;
import com.tech_613.podcast.utils.PreferenceManager;

public class DarkProfileFragment extends Fragment implements View.OnClickListener {

    private LinearLayout lin_click1,lin_click2,switch_them;
    public static DarkProfileFragment newInstance(){
        DarkProfileFragment darkProfileFragment=new DarkProfileFragment();
        return darkProfileFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dark_profilepage,container,false);
        initXml(view);
        return view;
    }

    public void initXml(View view)
    {
        lin_click1=view.findViewById(R.id.modify);
        lin_click1.setOnClickListener(this);
        lin_click2=view.findViewById(R.id.choose);
        lin_click2.setOnClickListener(this);
        switch_them=view.findViewById(R.id.theme);
        switch_them.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.modify:
                startActivity(new Intent(getActivity(), EditProfileActivity.class));
                getActivity().finish();
                break;
            case R.id.choose:
                startActivity(new Intent(getActivity(), TopChatLocation.class));
                getActivity().finish();
                break;
            case R.id.theme:
                PreferenceManager.setThem(2);
                FragmentTransaction transaction =getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, ProfileFragment.newInstance()).addToBackStack("tag").commit();
                break;
        }
    }
}
