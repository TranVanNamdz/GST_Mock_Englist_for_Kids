package com.example.gst_mock_englist_for_kids.view;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.adapter.TopicDetailsAdapter;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;
import com.example.gst_mock_englist_for_kids.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.room_database.database.Database;
import com.example.gst_mock_englist_for_kids.utils.Constants;

import java.util.List;
import java.util.Locale;



public class TopicDetailsActivity extends AppCompatActivity {

    private final String TAG = TopicDetailsActivity.class.getSimpleName();

    private TopicDetailsAdapter mTopicDetailsAdapter;

    private RecyclerView mRcvTopicDetails;

    private Database mDatabase;

    private TextToSpeech mTextToSpeech;

    private int idTopic = 0;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_details);
        initViews();
    }

    private void initViews() {
        mDatabase = Database.getInstance(TopicDetailsActivity.this);

        mRcvTopicDetails = findViewById(R.id.rcvTopicDetails);

        mTextToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int ttsLang = mTextToSpeech.setLanguage(Locale.US);
                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.d(TAG, "The language is not supported");
                    } else {
                        Log.d(TAG, "The language is supported");

                    }
                } else {
                    Toast.makeText(TopicDetailsActivity.this, "TTS Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            idTopic = bundle.getInt(Constants.KEY_ID_TOPIC);
        }
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<TopicDetails> list = mDatabase.iTopicDao().getListTopicDetails(idTopic);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (list != null) {
                            mTopicDetailsAdapter = new TopicDetailsAdapter(TopicDetailsActivity.this, list);
                            mRcvTopicDetails.setAdapter(mTopicDetailsAdapter);
                            mRcvTopicDetails.setHasFixedSize(true);
                            mTopicDetailsAdapter.onItemClickListener(new TopicDetailsAdapter.ClickItemTopicDetails() {
                                @Override
                                public void onClickItem(final View view, int position) {
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
                                    String tts = list.get(position).getNameTopicDetails();
                                    int speechStatus = mTextToSpeech.speak(tts, TextToSpeech.QUEUE_FLUSH, null);
                                    if (speechStatus == TextToSpeech.ERROR) {
                                        Log.d(TAG, "Error converting text to speech");
                                    }
                                }
                            });
                        } else {

                            Log.d(TAG, "No data for this Topic");
                        }

                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTextToSpeech != null) {
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
        }
    }
}
