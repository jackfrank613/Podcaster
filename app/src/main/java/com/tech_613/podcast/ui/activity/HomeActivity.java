package com.tech_613.podcast.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.EqualSpacingItemDecoration;
import com.tech_613.podcast.adpter.SubitemListAdapter;
import com.tech_613.podcast.adpter.TopListAdapter;
import com.tech_613.podcast.model.SeriousModel;
import com.tech_613.podcast.model.SubitemModel;
import com.tech_613.podcast.model.TopModel;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {

    private static int ITEM_WIDTH = 0;
    private static int ITEM_HEIGHT = 0;
    private ImageView imageView,imageView1;
    private RecyclerView top_recyclerview;
    public ArrayList<TopModel> topModels;
    private TopListAdapter topListAdapter;
    private RecyclerView subitem_recyclerview;
    private ArrayList<SeriousModel> seriousModels;
    private ArrayList<SubitemModel> subitemModels;
    private SubitemListAdapter subitemListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initXml();
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
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        ITEM_WIDTH = (width-dp2px(this, 60));
        ITEM_HEIGHT = (int) (ITEM_WIDTH * 0.61);
        imageView=(ImageView)findViewById(R.id.imageView3);
        imageView1=(ImageView)findViewById(R.id.imageView7);
        imageView.getLayoutParams().width=ITEM_WIDTH;
        imageView.getLayoutParams().height=ITEM_HEIGHT;
        imageView1.getLayoutParams().height=ITEM_HEIGHT;
        top_recyclerview=(RecyclerView)findViewById(R.id.top_rc);
        subitem_recyclerview=(RecyclerView)findViewById(R.id.subcategories);



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
}
