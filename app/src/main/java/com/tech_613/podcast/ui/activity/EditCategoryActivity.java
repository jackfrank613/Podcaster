package com.tech_613.podcast.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tech_613.podcast.MainActivity;
import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.EditListAdapter;
import com.tech_613.podcast.model.EditCategoryModel;

import java.util.ArrayList;

public class EditCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView edit_recyclerview;
    private Button bt_edit;
    private ImageView img_back;
    private EditListAdapter editListAdapter;
    private ArrayList<EditCategoryModel> editCategoryModels;
    private LinearLayout lin_click;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_edit_page);
        initXml();
        editListAdapter=new EditListAdapter(this,onEditList());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        edit_recyclerview.setLayoutManager(linearLayoutManager);
        edit_recyclerview.setAdapter(editListAdapter);
        editListAdapter.setImageClickListener(new EditListAdapter.OnEditClickListener() {
            @Override
            public void onSelectbutton(int count, int position) {
                if(count >=1)
                {
                    bt_edit.setBackgroundResource(R.drawable.button_background_pressed);

                }
                else {
                    bt_edit.setBackgroundResource(R.drawable.button_background_default);
                }
            }
        });

    }

    public void initXml(){
        bt_edit=findViewById(R.id.button);
        bt_edit.setOnClickListener(this);
        edit_recyclerview=findViewById(R.id.recyclerView);
        edit_recyclerview.setOnClickListener(this);
        lin_click=findViewById(R.id.layoutimage);
        lin_click.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.layoutimage:
                startActivity(new Intent(EditCategoryActivity.this, MainActivity.class));
                finish();
                break;
        }
    }

    public ArrayList<EditCategoryModel> onEditList(){

        editCategoryModels=new ArrayList<>();

        editCategoryModels.add(new EditCategoryModel("Arts","Books, Design, Fashion & Beauty, Food,\n" +
                "Performing Arts, Visual Arts"));

        editCategoryModels.add(new EditCategoryModel("Business","Careers, Entrepreneurship, Investing, \n" +
                "Management, Marketing, Non-profit"));
        editCategoryModels.add(new EditCategoryModel("Comedy","Comedy Interviews, Improv, Stand-Up"));
        editCategoryModels.add(new EditCategoryModel("History",""));
        editCategoryModels.add(new EditCategoryModel("Science","Astronomy, Chemistry, Earth Sciences,\n" +
                "Life Sciences, Mathematics, Nature,\n" +
                "Natural Sciences, Physics, Social Sciences"));


//        for(int i=0;i<19;i++)
//        {
//            EditCategoryModel editCategoryModel=new EditCategoryModel("Arts","Books, Design, Fashion & Beauty, Food,\n" +
//                    "Performing Arts, Visual Arts");
//            editCategoryModels.add(editCategoryModel);
//        }
        return editCategoryModels;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(EditCategoryActivity.this,MainActivity.class));
        finish();
    }
}
