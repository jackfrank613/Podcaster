package com.tech_613.podcast.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.adpter.DownloadListAdapter;
import com.tech_613.podcast.adpter.TopPagerAdapter;

public class DownloadFragment extends Fragment implements View.OnClickListener {
    private LinearLayout lin_click1, lin_click2;
    private View view1, view2;
    private TextView txt_ready, txt_progress;
    private ViewPager pager;
    private DownloadListAdapter downloadListAdapter;
    private LinearLayout image_arrow;

    public static DownloadFragment newInstance() {
        DownloadFragment downloadFragment = new DownloadFragment();
        return downloadFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_download_page, container, false);
        initXml(view);
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, ReadSubscriptionFragment.newInstance()).addToBackStack("tag").commit();

        image_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, SubscriptionFragment.newInstance()).addToBackStack("tag").commit();
            }
        });
        return view;
    }

    public void initXml(View view) {
        lin_click1 = (LinearLayout) view.findViewById(R.id.relative1);
        lin_click1.setOnClickListener(this);
        lin_click2 = (LinearLayout) view.findViewById(R.id.relative2);
        lin_click2.setOnClickListener(this);
        view1 = (View) view.findViewById(R.id.view1);
        view2 = (View) view.findViewById(R.id.view2);
        txt_ready = view.findViewById(R.id.local);
        txt_progress = view.findViewById(R.id.global);
        image_arrow = view.findViewById(R.id.imageView6);
        image_arrow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.relative1:
                view1.setVisibility(View.VISIBLE);
                txt_ready.setAlpha((float) 0.8);
                txt_progress.setAlpha((float) 0.5);
                view2.setVisibility(View.INVISIBLE);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, ReadSubscriptionFragment.newInstance()).addToBackStack("tag").commit();
                break;
            case R.id.relative2:
                view1.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
                txt_progress.setAlpha((float) 0.8);
                txt_ready.setAlpha((float) 0.5);
                FragmentTransaction transaction1 = getActivity().getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.container, ProgressSubscriptionFragment.newInstance()).addToBackStack("tag").commit();

                break;
            case R.id.imageView6:

                break;

        }
    }
}
