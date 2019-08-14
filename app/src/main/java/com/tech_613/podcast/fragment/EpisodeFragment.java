package com.tech_613.podcast.fragment;

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
import com.tech_613.podcast.adpter.EpisodeListAdapter;
import com.tech_613.podcast.model.EpisodeModel;

import java.util.ArrayList;

public class EpisodeFragment extends Fragment {


    private RecyclerView recy_episode;

    public static EpisodeFragment newInstance(){
        EpisodeFragment episodeFragment=new EpisodeFragment();
        return episodeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_episode,container,false);
        recy_episode=view.findViewById(R.id.episode_recycler);
        EpisodeListAdapter episodeListAdapter=new EpisodeListAdapter(getActivity(),onEpisodeList());
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recy_episode.setLayoutManager(linearLayoutManager);
        recy_episode.setAdapter(episodeListAdapter);
        return view;
    }

    public ArrayList<EpisodeModel> onEpisodeList()
    {
        ArrayList<EpisodeModel> episodeModels=new ArrayList<>();

        episodeModels.add(new EpisodeModel("Get your work Seen w/Mark...","July24.2019","12:30"));
        episodeModels.add(new EpisodeModel("You've Been Lied To And it's...","June7.2019","1:12:30"));
        return episodeModels;
    }
}
