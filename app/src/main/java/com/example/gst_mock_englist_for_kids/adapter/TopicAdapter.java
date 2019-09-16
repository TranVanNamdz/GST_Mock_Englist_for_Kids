package com.example.gst_mock_englist_for_kids.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.room_database.database.Database;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicViewHolder> {
    private static ClickListener mListener;

    private final Context mContext;

    private final List<Topic> mList;


    private final LayoutInflater mInflater;

    private int mIndex = 0;


    public TopicAdapter(Context context, List<Topic> list) {
        this.mContext = context;
        this.mList = list;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        final Topic topic = mList.get(position);
        holder.imgTopic.setImageBitmap(getBitmapFromAssets(topic.getImgTopic()));
        holder.tvNameTopic.setText(topic.getNameTopic());
    }

    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    private Bitmap getBitmapFromAssets(String fileName) {

        AssetManager am = mContext.getAssets();
        InputStream is = null;
        try {

            is = am.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return BitmapFactory.decodeStream(is);
    }

    @Override
    public void onViewAttachedToWindow(@NonNull final TopicViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.itemView.post(new Runnable() {
            @Override
            public void run() {
                AnimationSet mAnimationSet = new AnimationSet(false);
                AlphaAnimation mFade = new AlphaAnimation(0.0f, 1.5f);
                mFade.setDuration(1000);
                TranslateAnimation mTranslateAnimation;
                if (holder.getAdapterPosition() > mIndex) {
                    mTranslateAnimation = new TranslateAnimation(0, 0, holder.itemView.getHeight(), 0);
                } else {
                    mTranslateAnimation = new TranslateAnimation(0, 0, -holder.itemView.getHeight(), 0);

                }
                mIndex = holder.getAdapterPosition();
                mTranslateAnimation.setDuration(1000);
                mAnimationSet.addAnimation(mFade);
                mAnimationSet.addAnimation(mTranslateAnimation);
                holder.itemView.startAnimation(mAnimationSet);
            }
        });
    }

    class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imgTopic;

        private TextView tvNameTopic;


        Database topicDatabase;


        TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imgTopic = itemView.findViewById(R.id.imgTopic);
            tvNameTopic = itemView.findViewById(R.id.tvNameTopic);
            topicDatabase = Database.getInstance(mContext);

        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(v, getAdapterPosition());
        }
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        mListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View view, int position);
    }
}
