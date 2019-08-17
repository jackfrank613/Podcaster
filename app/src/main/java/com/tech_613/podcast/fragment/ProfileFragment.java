package com.tech_613.podcast.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tech_613.podcast.R;
import com.tech_613.podcast.ui.activity.EditProfileActivity;
import com.tech_613.podcast.ui.activity.TopChatLocation;
import com.tech_613.podcast.utils.PreferenceManager;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    private LinearLayout lin_click1,lin_click2,switch_them;
    private boolean check=true;
    public static ProfileFragment newInstance(){
        ProfileFragment profileFragment=new ProfileFragment();
        return profileFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = null;
        if(PreferenceManager.getThem()==1)
        {
            view=inflater.inflate(R.layout.activity_dark_profilepage,container,false);
        }
        else {
            view=inflater.inflate(R.layout.activity_profile,container,false);
        }

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
                if(PreferenceManager.check)
                {
                    PreferenceManager.setThem(1);
                    new Handler().post(new Runnable() {

                        @Override
                        public void run()
                        {
                            Intent intent = getActivity().getIntent();
                            intent.putExtra("fragment","theme");
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            getActivity().overridePendingTransition(0, 0);
                            getActivity().finish();

                            getActivity().overridePendingTransition(0, 0);
                            startActivity(intent);
                        }
                    });
                    PreferenceManager.check=false;
                }
                else {

                    PreferenceManager.setThem(2);
                    new Handler().post(new Runnable() {

                        @Override
                        public void run()
                        {
                            Intent intent = getActivity().getIntent();
                            intent.putExtra("fragment","theme");
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
                                    | Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            getActivity().overridePendingTransition(0, 0);
                            getActivity().finish();

                            getActivity().overridePendingTransition(0, 0);
                            startActivity(intent);
                        }
                    });
                    PreferenceManager.check=true;
                }

                break;
        }
    }
}
