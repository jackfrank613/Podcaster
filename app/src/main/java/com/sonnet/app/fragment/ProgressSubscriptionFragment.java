package com.tech_613.podcast.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.DownloadListAdapter;
import com.tech_613.podcast.adpter.Top40glAdapter;
import com.tech_613.podcast.model.DownloadModel;
import com.tech_613.podcast.model.Top40glModel;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;

public class ProgressSubscriptionFragment extends Fragment {
    private RecyclerView page_recyclerview;
    private DownloadListAdapter downloadListAdapter;
    private ArrayList<DownloadModel> downloadModels;
    private ConstraintLayout global_layout;

    public static ProgressSubscriptionFragment newInstance(){

        ProgressSubscriptionFragment progressSubscriptionFragment=new ProgressSubscriptionFragment();
        return progressSubscriptionFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_global,container,false);
        global_layout=view.findViewById(R.id.global_fragment);
        if(PreferenceManager.getThem()==1)
        {
            global_layout.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.dark));
        }
        else {
            global_layout.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.background));
        }
        page_recyclerview=view.findViewById(R.id.page2);
        downloadListAdapter=new DownloadListAdapter(getActivity(),onProgress());
        page_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        page_recyclerview.setAdapter(downloadListAdapter);
        page_recyclerview.setFocusable(false);
        return view;
    }

    public ArrayList<DownloadModel> onProgress(){
        downloadModels=new ArrayList<>();
        downloadModels.add(new DownloadModel(R.drawable.zhen,"Episode 194 : Bring Back","1 day ago","44:31",true));
        return downloadModels;
    }
}
