package com.tech_613.podcast.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.SearchListAdapter;
import com.tech_613.podcast.model.SearchModel;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView s_recycler;
    private SearchListAdapter searchListAdapter;
    private ArrayList<SearchModel> searchModels;
    private SearchView searchView;
    private LinearLayout empty_layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_screen);
        initXml();
        getList();
        searchView.setOnQueryTextListener(listener);
        if(searchModels.isEmpty())
        {
            s_recycler.setVisibility(View.GONE);
            empty_layout.setVisibility(View.VISIBLE);
        }
        else {
            s_recycler.setVisibility(View.VISIBLE);
            empty_layout.setVisibility(View.GONE);
        }

    }
    public void initXml(){
        s_recycler=findViewById(R.id.s_recyclerview);
        searchView=findViewById(R.id.searchview);
        empty_layout=findViewById(R.id.emptylayout);
    }
    public void getList(){
        searchListAdapter=new SearchListAdapter(this,onSearchList());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        s_recycler.setLayoutManager(linearLayoutManager);
        s_recycler.setAdapter(searchListAdapter);
        s_recycler.setFocusable(false);
    }
    public ArrayList<SearchModel> onSearchList(){
        searchModels=new ArrayList<>();

        for(int i=0;i<40;i++)
        {
            if(i%2==0)
            {
                searchModels.add(new SearchModel(R.drawable.byone,"Design Matters with Zoe Zhen present","Design Observer"));
            }
            else {
                searchModels.add(new SearchModel(R.drawable.byone,"The Truth","Jane Portman"));
            }
        }
        return searchModels;
    }

    SearchView.OnQueryTextListener listener=new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String s) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String s) {

            ArrayList<SearchModel> newList=new ArrayList<>();
            for(int i=0;i<searchModels.size();i++)
            {
                if(searchModels.get(i).getTop_topic().contains(s)||searchModels.get(i).getTop_body().contains(s))
                {
                    newList.add(searchModels.get(i));
                }

            }
            if (newList.isEmpty()){
                s_recycler.setVisibility(View.GONE);
                empty_layout.setVisibility(View.VISIBLE);

            }else
            {
                s_recycler.setVisibility(View.VISIBLE);
                empty_layout.setVisibility(View.GONE);
                searchListAdapter.setFilter(newList);
            }
            return true;
        }
    };
}
