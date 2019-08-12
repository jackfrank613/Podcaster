package com.tech_613.podcast.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.EqualSpacingItemDecoration;
import com.tech_613.podcast.adpter.SubscriptionListAdapter;
import com.tech_613.podcast.model.SubscriptionModel;

import java.util.ArrayList;

public class SubscriptionFragment extends Fragment {

    private RecyclerView sub_recyclerview;
    private ImageView img_downlaod;
    private SubscriptionListAdapter subscriptionListAdapter;
    private ArrayList<SubscriptionModel> subscriptionModels;
    private LinearLayout lin_downlaod;
    public static SubscriptionFragment newInstance(){

        SubscriptionFragment subscriptionFragment=new SubscriptionFragment();
        return subscriptionFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.activity_subscription,container,false);
       sub_recyclerview=view.findViewById(R.id.sub_recyclerviw);
        lin_downlaod=view.findViewById(R.id.lin_downlaod);
       subscriptionListAdapter=new SubscriptionListAdapter(getActivity(),onSubscriptList());
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getActivity(),3);
        sub_recyclerview.addItemDecoration(new EqualSpacingItemDecoration(0, EqualSpacingItemDecoration.GRID));
        sub_recyclerview.setLayoutManager(linearLayoutManager);
        sub_recyclerview.setAdapter(subscriptionListAdapter);


        lin_downlaod.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FragmentTransaction transaction=getActivity().getSupportFragmentManager().beginTransaction();
              transaction.add(R.id.frame_container,DownloadFragment.newInstance()).addToBackStack("tag").commit();
          }
      });
       return view;
    }

    public ArrayList<SubscriptionModel> onSubscriptList(){

        subscriptionModels=new ArrayList<>();
        for(int i=0;i<6;i++){
            SubscriptionModel subscriptionModel=new SubscriptionModel(R.drawable.top,"The Road that\nlead to nowh...","iHeartRadio");
            subscriptionModels.add(subscriptionModel);
        }
        return subscriptionModels;
    }
}
