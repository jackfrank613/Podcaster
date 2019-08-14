package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.LocationAdapter;
import com.tech_613.podcast.model.LocationModel;

import java.util.ArrayList;

public class TopChatLocation extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recycler_location;
    private LinearLayout lin_back;
    private ArrayList<LocationModel> locationModels;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.top_chart_location);
        initXml();
        LocationAdapter locationAdapter=new LocationAdapter(this,onLocationList());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler_location.setLayoutManager(linearLayoutManager);
        recycler_location.setAdapter(locationAdapter);
    }
    public void initXml(){
        recycler_location=findViewById(R.id.recyclerView);
        lin_back=findViewById(R.id.layoutimage);
        lin_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.layoutimage:
                Intent intent=new Intent(TopChatLocation.this, MainActivity.class);
                intent.putExtra("fragment","Location");
                startActivity(intent);
                finish();
                break;
        }
    }

    public ArrayList<LocationModel> onLocationList(){
        locationModels=new ArrayList<>();

        for(int i=0;i<3;i++)
        {
            LocationModel locationModel=new LocationModel(R.drawable.ic_us,"U.S.","Howdy");
            locationModels.add(locationModel);
        }

        return locationModels;
    }
}
