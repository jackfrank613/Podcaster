package com.tech_613.podcast.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.BannerListAdapter;
import com.tech_613.podcast.adpter.EqualSpacingItemDecoration;
import com.tech_613.podcast.adpter.SubitemListAdapter;
import com.tech_613.podcast.adpter.TopListAdapter;
import com.tech_613.podcast.model.BannerModel;
import com.tech_613.podcast.model.SeriousModel;
import com.tech_613.podcast.model.SubitemModel;
import com.tech_613.podcast.model.TopModel;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private static int ITEM_WIDTH = 0;
    private static int ITEM_HEIGHT = 0;
    private ImageView imageView,imageView1,edit_pencil;
    private RecyclerView top_recyclerview;
    public ArrayList<TopModel> topModels;
    private TopListAdapter topListAdapter;
    private RecyclerView subitem_recyclerview,banner_recyclerview;
    private ArrayList<SeriousModel> seriousModels;
    private ArrayList<SubitemModel> subitemModels;
    private SubitemListAdapter subitemListAdapter;
    private ArrayList<BannerModel> bannerModels;
    private BannerListAdapter bannerListAdapter;
    private ImageView bottom1,bottom2,bottom3,bottom4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initXml();
        bannerListAdapter=new BannerListAdapter(this,onBannerList());
        LinearLayoutManager linearLayoutManager2=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        banner_recyclerview.setLayoutManager(linearLayoutManager2);
        banner_recyclerview.setAdapter(bannerListAdapter);
        topListAdapter=new TopListAdapter(this,onTopList());
        GridLayoutManager linearLayoutManager=new GridLayoutManager(this,3);
        top_recyclerview.addItemDecoration(new EqualSpacingItemDecoration(0, EqualSpacingItemDecoration.GRID));
        top_recyclerview.setLayoutManager(linearLayoutManager);
        top_recyclerview.setAdapter(topListAdapter);
        subitemListAdapter=new SubitemListAdapter(this,onSubitemList());
        LinearLayoutManager linearLayoutManager1=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        subitem_recyclerview.setLayoutManager(linearLayoutManager1);
        subitem_recyclerview.setAdapter(subitemListAdapter);
    }

    public void initXml(){
        banner_recyclerview=(RecyclerView)findViewById(R.id.imageView3);
        top_recyclerview=(RecyclerView)findViewById(R.id.top_rc);
        subitem_recyclerview=(RecyclerView)findViewById(R.id.subcategories);
        bottom1=findViewById(R.id.bt1);
        bottom1.setOnClickListener(this);
        bottom2=findViewById(R.id.bt2);
        bottom2.setOnClickListener(this);
        bottom3=findViewById(R.id.bt3);
        bottom3.setOnClickListener(this);
        bottom4=findViewById(R.id.bt4);
        bottom4.setOnClickListener(this);
        edit_pencil=findViewById(R.id.imageView5);
        edit_pencil.setOnClickListener(this);




    }
    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.bt1:
                 onChangebutton(0);
                break;
            case R.id.bt2:
                onChangebutton(1);
                break;
            case R.id.bt3:
                onChangebutton(2);
                break;
            case R.id.bt4:
                onChangebutton(3);
                break;
            case R.id.imageView5:
                startActivity(new Intent(HomeActivity.this,EditCategoryActivity.class));
                break;
        }
    }

    public void onChangebutton(int p){

        switch (p)
        {
            case 0:
                 bottom1.setImageResource(R.drawable.ic_compas);
                 bottom2.setImageResource(R.drawable.ic_gsearch);
                 bottom3.setImageResource(R.drawable.ic_gstar);
                 bottom4.setImageResource(R.drawable.ic_gprofile);


//                bottom1.setImageResource(R.drawable.ic_discover1);
//                bottom2.setImageResource(R.drawable.ic_gdsearch);
//                bottom3.setImageResource(R.drawable.ic_gdstar);
//                bottom4.setImageResource(R.drawable.ic_gdprofile);
                break;
            case 1:
                bottom1.setImageResource(R.drawable.ic_gcompas);
                bottom2.setImageResource(R.drawable.ic_search);
                bottom3.setImageResource(R.drawable.ic_gstar);
                bottom4.setImageResource(R.drawable.ic_gprofile);

//                bottom1.setImageResource(R.drawable.ic_gddiscover);
//                bottom2.setImageResource(R.drawable.ic_dsearch);
//                bottom3.setImageResource(R.drawable.ic_gdstar);
//                bottom4.setImageResource(R.drawable.ic_gdprofile);
                break;
            case 2:
                bottom1.setImageResource(R.drawable.ic_gcompas);
                bottom2.setImageResource(R.drawable.ic_gsearch);
                bottom3.setImageResource(R.drawable.ic_star);
                bottom4.setImageResource(R.drawable.ic_gprofile);

//                bottom1.setImageResource(R.drawable.ic_gddiscover);
//                bottom2.setImageResource(R.drawable.ic_gdsearch);
//                bottom3.setImageResource(R.drawable.ic_dstar);
//                bottom4.setImageResource(R.drawable.ic_gdprofile);
                break;
            case 3:
                bottom1.setImageResource(R.drawable.ic_gcompas);
                bottom2.setImageResource(R.drawable.ic_gsearch);
                bottom3.setImageResource(R.drawable.ic_gstar);
                bottom4.setImageResource(R.drawable.ic_profile);


//                bottom1.setImageResource(R.drawable.ic_gddiscover);
//                bottom2.setImageResource(R.drawable.ic_gdsearch);
//                bottom3.setImageResource(R.drawable.ic_gdstar);
//                bottom4.setImageResource(R.drawable.ic_dprofile);
                break;
        }

    }
}
