package com.example.gst_mock_englist_for_kids.view;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.adapter.TopicAdapter;
import com.example.gst_mock_englist_for_kids.entities.Topic;
import com.example.gst_mock_englist_for_kids.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.room_database.database.Database;
import com.example.gst_mock_englist_for_kids.utils.Constants;
import com.example.gst_mock_englist_for_kids.utils.DataForDatabase;

import java.util.List;



public class TopicActivity extends AppCompatActivity {

    private static final String TAG = TopicActivity.class.getSimpleName();

    @SuppressWarnings("FieldCanBeLocal")
    private RecyclerView mRcvTopic;

    @SuppressWarnings("FieldCanBeLocal")
    private TopicAdapter mTopicAdapter;


    private Database mDatabase;

    @SuppressWarnings("FieldCanBeLocal")
    private DataForDatabase mDataForDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        insertDataToDatabase();
        initViews();
    }

    private void initViews() {
        mDatabase = Database.getInstance(this);

        mRcvTopic = findViewById(R.id.rcvTopic);
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<Topic> list = mDatabase.iTopicDao().getTopicList();
                Log.d(TAG, list.size() + " get list");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTopicAdapter = new TopicAdapter(TopicActivity.this, list);
                        mRcvTopic.setAdapter(mTopicAdapter);
                        mRcvTopic.setHasFixedSize(true);
                        mTopicAdapter.setOnItemClickListener(new TopicAdapter.ClickListener() {
                            @Override
                            public void onItemClick(final View view, int position) {

                                final ValueAnimator value = ValueAnimator.ofFloat(0.5f, 1f);
                                value.setDuration(400);
                                value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                    @Override
                                    public void onAnimationUpdate(ValueAnimator animation) {
                                        float progress = (float) value.getAnimatedValue();
                                        view.setScaleX(progress);
                                        view.setScaleY(progress);
                                    }
                                });
                                value.start();

                                Bundle bundle = new Bundle();
                                bundle.putInt(Constants.KEY_ID_TOPIC, list.get(position).getIdTopic());
                                Intent intent = new Intent(TopicActivity.this, TopicDetailsActivity.class);
                                intent.putExtras(bundle);
                                startActivity(intent);
                            }
                        });
                    }
                });
            }
        });


    }

    private void insertDataToDatabase() {
        mDataForDatabase = new DataForDatabase(TopicActivity.this);
        mDataForDatabase.addDataTopicTable();
        mDataForDatabase.addDataTopicDetailsTable();
    }
}
