package com.tech_613.podcast.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.BannerListAdapter;
import com.tech_613.podcast.adpter.EqualSpacingItemDecoration;
import com.tech_613.podcast.adpter.SubitemListAdapter;
import com.tech_613.podcast.adpter.TopListAdapter;
import com.tech_613.podcast.model.BannerModel;
import com.tech_613.podcast.model.SeriousModel;
import com.tech_613.podcast.model.SubitemModel;
import com.tech_613.podcast.model.TopModel;
import com.tech_613.podcast.ui.activity.EditCategoryActivity;
import com.tech_613.podcast.utils.PreferenceManager;

import java.util.ArrayList;

public class PoadCastFragment extends Fragment implements View.OnClickListener{

    private LinearLayout edit_pencil;
    private RecyclerView top_recyclerview;
    public ArrayList<TopModel> topModels;
    private TopListAdapter topListAdapter;
    private RecyclerView subitem_recyclerview,banner_recyclerview;
    private ArrayList<SeriousModel> seriousModels;
    private ArrayList<SubitemModel> subitemModels;
    private SubitemListAdapter subitemListAdapter;
    private ArrayList<BannerModel> bannerModels;
    private BannerListAdapter bannerListAdapter;
    private TextView text_all;


    public static PoadCastFragment newInstance(){
        PoadCastFragment poadCastFragment=new PoadCastFragment();
        return poadCastFragment;
    }


    @SuppressLint("ClickableViewAccessibility")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=null;
        if(PreferenceManager.getThem()==1)
        {
            view=inflater.inflate(R.layout.activity_dark_home_screen,container,false);
        }
        else {
            view=inflater.inflate(R.layout.activity_home_screen,container,false);
        }

        initXml(view);
        bannerListAdapter=new BannerListAdapter(getActivity(),onBannerList());
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        banner_recyclerview.setLayoutManager(linearLayoutManager2);
        banner_recyclerview.setAdapter(bannerListAdapter);
        topListAdapter=new TopListAdapter(getActivity(),onTopList());
        GridLayoutManager linearLayoutManager=new GridLayoutManager(getActivity(),3);
        top_recyclerview.addItemDecoration(new EqualSpacingItemDecoration(0, EqualSpacingItemDecoration.GRID));
        top_recyclerview.setLayoutManager(linearLayoutManager);
        top_recyclerview.setAdapter(topListAdapter);
        subitemListAdapter=new SubitemListAdapter(getActivity(),onSubitemList());
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        subitem_recyclerview.setLayoutManager(linearLayoutManager1);
        subitem_recyclerview.setAdapter(subitemListAdapter);
        return view;
    }

    public void initXml(View view){

        banner_recyclerview=(RecyclerView)view.findViewById(R.id.imageView3);
        top_recyclerview=(RecyclerView)view.findViewById(R.id.top_rc);
        subitem_recyclerview=(RecyclerView)view.findViewById(R.id.subcategories);
        text_all=view.findViewById(R.id.textView6);
        text_all.setOnClickListener(this);
        edit_pencil=view.findViewById(R.id.imageView5);
        edit_pencil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.imageView5:
                startActivity(new Intent(getActivity(), EditCategoryActivity.class));
                getActivity().finish();
                break;

            case R.id.textView6:
                FragmentTransaction transaction3 = getActivity().getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.frame_container, Top40glFragment.newInstance()).addToBackStack("tag").commit();
                break;
        }
    }



    public ArrayList<TopModel> onTopList()
    {
        topModels=new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            TopModel model=new TopModel(R.drawable.top,"The Road that\nlead to nowh...","iHeartRadio");
            topModels.add(model);
        }

        return topModels;
    }

    public ArrayList<SeriousModel> onSeriousList(){
        seriousModels=new ArrayList<>();
        for(int i=0;i<6;i++){

            SeriousModel seriousModel=new SeriousModel(R.drawable.top,"The Road that\nlead to nowh...","iHeartRadio");
            seriousModels.add(seriousModel);
        }
        return seriousModels;
    }

    public ArrayList<SubitemModel> onSubitemList(){
        subitemModels=new ArrayList<>();
        for(int i=0;i<3;i++)
        {
            SubitemModel subitemModel=new SubitemModel("Arts",onSeriousList());
            subitemModels.add(subitemModel);

        }
        return subitemModels;
    }

    public ArrayList<BannerModel> onBannerList(){
        bannerModels=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            BannerModel bannerModel=new BannerModel(R.drawable.banner);
            bannerModels.add(bannerModel);
        }
        return bannerModels;
    }
}
