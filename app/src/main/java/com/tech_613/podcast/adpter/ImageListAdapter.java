package com.tech_613.podcast.adpter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.ImageModel;

import java.util.ArrayList;

import static android.content.Context.WINDOW_SERVICE;
import static android.media.CamcorderProfile.get;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {

    private static int ITEM_WIDTH = 0;
    private static int ITEM_HEIGHT = 0;
    private Context context;
    private ArrayList<ImageModel> imagePaths;
    private SparseBooleanArray itemStateArray= new SparseBooleanArray();
    private OnImageListener onImageListener;
    private int count=0;
    public ImageListAdapter(Context context, ArrayList<ImageModel> imagePaths)

    {
        this.context=context;
        this.imagePaths=imagePaths;
        WindowManager wm = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        final DisplayMetrics displayMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(displayMetrics);
        ITEM_WIDTH = (displayMetrics.widthPixels-dp2px(context, (int)65))/2;
        ITEM_HEIGHT = (int) (ITEM_WIDTH * 1.11);

    }

    @NonNull
    @Override
    public ImageListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.category_items,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageListAdapter.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        viewHolder.bind(i);
        final ImageModel model=imagePaths.get(i);
        viewHolder.img_list.setImageResource(model.getImage_drawable());
        GridLayoutManager.LayoutParams layoutParams = (GridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams();
        layoutParams.height=ITEM_HEIGHT;
        layoutParams.width = ITEM_WIDTH;
        if (i%2==1) layoutParams.leftMargin=dp2px(context, (int) 7.6);
        else layoutParams.leftMargin=0;
        layoutParams.rightMargin=0;
        layoutParams.bottomMargin = dp2px(context,18);
        if ((int)(i/2)==0) layoutParams.topMargin = dp2px(context,18);
        else layoutParams.topMargin = 0;
        viewHolder.itemView.setLayoutParams(layoutParams);
    }

    @Override
    public int getItemCount() {
        return imagePaths.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        ConstraintLayout constraintLayout;
        ImageView img_list, image_tricker;
        CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_list = itemView.findViewById(R.id.imageView2);
            image_tricker = itemView.findViewById(R.id.tricker);
            constraintLayout=itemView.findViewById(R.id.contraintlayout);
            cardView=itemView.findViewById(R.id.card_layout);
            itemView.setOnClickListener(this);
        }

        void bind(int position) {
            // use the sparse boolean array to check
            if (imagePaths.get(position).isCheck()) {
                image_tricker.setVisibility(View.VISIBLE);
            }
            else {
                image_tricker.setVisibility(View.INVISIBLE);
            }
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            if(imagePaths.get(adapterPosition).isCheck())
            {
                count--;
                image_tricker.setVisibility(View.INVISIBLE);
                imagePaths.get(adapterPosition).setCheck(false);
                if(onImageListener!=null)
                    onImageListener.onSelectbutton(count,adapterPosition);
            }
            else {
                count++;
                image_tricker.setVisibility(View.VISIBLE);
                imagePaths.get(adapterPosition).setCheck(true);
                if(onImageListener!=null)
                    onImageListener.onSelectbutton(count,adapterPosition);
            }
        }
    }
    public void setImageClickListener(OnImageListener onImageListener)
    {
        this.onImageListener=onImageListener;
    }
    public interface OnImageListener{

        void onImageClick(String path);
        void onSelectbutton(int count,int position);
    }

    public static int dp2px(Context context, int dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }
}
