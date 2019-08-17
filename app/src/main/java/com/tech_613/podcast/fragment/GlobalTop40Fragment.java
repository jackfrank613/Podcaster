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
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.Top40glAdapter;
import com.tech_613.podcast.model.Top40glModel;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;

public class GlobalTop40Fragment extends Fragment {

    private RecyclerView page_recyclerview;
    private Top40glAdapter top40glAdapter;
    private ArrayList<Top40glModel> top40glModels;
    private ConstraintLayout local_layout;
    public static GlobalTop40Fragment newInstance(){

        GlobalTop40Fragment globalTop40Fragment=new GlobalTop40Fragment();
        return globalTop40Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_global,container,false);
        local_layout=view.findViewById(R.id.global_fragment);
        if(PreferenceManager.getThem()==1){
            local_layout.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.dark));
        }
        else {
            local_layout.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.background));
        }
        page_recyclerview=view.findViewById(R.id.page2);
        top40glAdapter=new Top40glAdapter(getActivity(),onGlobalList());
        page_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        page_recyclerview.setAdapter(top40glAdapter);
        page_recyclerview.setFocusable(false);
        return view;
    }

    public ArrayList<Top40glModel> onGlobalList(){
        top40glModels=new ArrayList<>();
        for(int i=0;i<40;i++)
        {
            if(i%2==0)
            {
                top40glModels.add(new Top40glModel(R.drawable.byone,"The Truth","Jane Portman",String.valueOf(i+1)+"."));
            }
            else {


                top40glModels.add(new Top40glModel(R.drawable.byone,"Design Matters with Zoe Zhen present","Design Observer",String.valueOf(i+1)+"."));
            }


        }

//        top40glModels.add(new Top40glModel(R.drawable.byone,"Design Matters with Zoe","Design Observer","2."));
//

        return top40glModels;
    }
}
