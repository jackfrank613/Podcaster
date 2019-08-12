package com.tech_613.podcast.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.Top40glAdapter;
import com.tech_613.podcast.model.Top40glModel;

import java.util.ArrayList;

public class LocalTop40Fragment extends Fragment{

    private RecyclerView page_recyclerview;
    private Top40glAdapter top40glAdapter;
    private ArrayList<Top40glModel> top40glModels;
    public static LocalTop40Fragment newInstance(){
        LocalTop40Fragment localTop40Fragment=new LocalTop40Fragment();
        return localTop40Fragment;
    }


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_local,container,false);
        page_recyclerview=view.findViewById(R.id.page1);
        top40glAdapter=new Top40glAdapter(getActivity(),onLocalList());
        page_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        page_recyclerview.setAdapter(top40glAdapter);
        page_recyclerview.setFocusable(false);




        return view;
    }

    public ArrayList<Top40glModel> onLocalList(){
        top40glModels=new ArrayList<>();

        for(int i=0;i<40;i++)
        {
            if(i%2==0)
            {
                top40glModels.add(new Top40glModel(R.drawable.byone,"Design Matters with Zoe Zhen present","Design Observer",String.valueOf(i+1)+"."));
            }
            else {
                top40glModels.add(new Top40glModel(R.drawable.byone,"The Truth","Jane Portman",String.valueOf(i+1)+"."));
            }

        }
//        top40glModels.add(new Top40glModel(R.drawable.byone,"Design Matters with Zoe Zhen present","Design Observer","1."));
//        top40glModels.add(new Top40glModel(R.drawable.byone,"The Truth","Jane Portman","39."));

        return top40glModels;
    }


}
