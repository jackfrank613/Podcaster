package com.tech_613.podcast.adpter;

import android.content.Context;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tech_613.podcast.R;
import com.tech_613.podcast.model.EditCategoryModel;

import java.util.ArrayList;

public class EditListAdapter extends RecyclerView.Adapter<EditListAdapter.ViewHolder> {

    Context context;
    ArrayList<EditCategoryModel> editCategoryModels;
    private OnEditClickListener onEditClickListener;
    int count=0;
    public EditListAdapter(Context context,ArrayList<EditCategoryModel> editCategoryModels){
        this.context=context;
        this.editCategoryModels=editCategoryModels;
    }
    @NonNull
    @Override
    public EditListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.edit_category_item,viewGroup,false);
       return new EditListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EditListAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(i);
        EditCategoryModel editCategoryModel=editCategoryModels.get(i);
        viewHolder.txt_title.setText(editCategoryModel.getC_title());
//        viewHolder.txt_title.setTextColor(Color.WHITE);
        viewHolder.txt_description.setText(editCategoryModel.getC_description());
//        viewHolder.txt_description.setTextColor(Color.WHITE);
//        viewHolder.txt_description.setAlpha((float) 0.7);
    }

    @Override
    public int getItemCount() {
        return editCategoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView txt_title,txt_description;
        ImageView img_check;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_title=itemView.findViewById(R.id.textView11);
            txt_description=itemView.findViewById(R.id.textView12);
            img_check=itemView.findViewById(R.id.imageView7);
            itemView.setOnClickListener(this);
        }
      void bind(int postion)
      {
          if(editCategoryModels.get(postion).isCheck())
          {
              img_check.setImageResource(R.drawable.ic_check);

          }
          else {
              img_check.setImageResource(R.drawable.ic_gcheck);
          }
      }
        @Override
        public void onClick(View v) {
            int adapterpostion=getAdapterPosition();
            if(editCategoryModels.get(adapterpostion).isCheck())
            {
                count--;
                img_check.setImageResource(R.drawable.ic_gcheck);
                editCategoryModels.get(adapterpostion).setCheck(false);
                if(onEditClickListener!=null)
                    onEditClickListener.onSelectbutton(count,adapterpostion);
            }
            else {
                count++;
                img_check.setImageResource(R.drawable.ic_check);
                editCategoryModels.get(adapterpostion).setCheck(true);
                if(onEditClickListener!=null)
                    onEditClickListener.onSelectbutton(count,adapterpostion);
            }
        }
    }
    public void setImageClickListener(OnEditClickListener onEditClickListener)
    {
        this.onEditClickListener=onEditClickListener;
    }
    public interface OnEditClickListener {

        void onSelectbutton(int count,int position);
    }
}
