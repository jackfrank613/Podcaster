package com.tech_613.podcast.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.ScreenItem;

import java.util.List;

public class OnboardingViewpagerAdapter extends PagerAdapter {

    Context mContext;
    List<ScreenItem> screenItems;

    public OnboardingViewpagerAdapter(Context mContext, List<ScreenItem> screenItems) {
        this.mContext = mContext;
        this.screenItems = screenItems;
    }

    @Override
    public int getCount() {
        return screenItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==o;

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen=inflater.inflate(R.layout.onboarding,null);
        ImageView imgSlide=layoutScreen.findViewById(R.id.imageslide);
        TextView title1=layoutScreen.findViewById(R.id.listen_to_y);
        TextView description1=layoutScreen.findViewById(R.id.access_your);
        title1.setText(screenItems.get(position).getTitle());
        description1.setText(screenItems.get(position).getDescription());
        imgSlide.setImageResource(screenItems.get(position).getScreenimage());
        container.addView(layoutScreen);
        return layoutScreen;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
