package com.example.gst_mock_englist_for_kids.view.fragment;

import android.animation.ValueAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gst_mock_englist_for_kids.R;
import com.example.gst_mock_englist_for_kids.adapter.TopicDetailsAdapter;
import com.example.gst_mock_englist_for_kids.entities.TopicDetails;
import com.example.gst_mock_englist_for_kids.executors.MyExecutors;
import com.example.gst_mock_englist_for_kids.room_database.database.Database;
import com.example.gst_mock_englist_for_kids.utils.Constants;

import java.util.List;
import java.util.Locale;
import java.util.Objects;


public class TopicDetailsFragment extends Fragment {
    private final String TAG = TopicFragment.class.getSimpleName();

    private TopicDetailsAdapter mTopicDetailsAdapter;

    private RecyclerView mRcvTopicDetails;

    private Database mDatabase;

    private TextToSpeech mTextToSpeech;

    private int idTopic = 0;

    public TopicDetailsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic_details, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        mDatabase = Database.getInstance(getContext());

        mRcvTopicDetails = view.findViewById(R.id.rcvTopicDetails);

        mTextToSpeech = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
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
                    Toast.makeText(getContext(), "TTS Initialization failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            idTopic = bundle.getInt(Constants.KEY_ID_TOPIC);
        }
        MyExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                final List<TopicDetails> list = mDatabase.iTopicDao().getListTopicDetails(idTopic);
                Objects.requireNonNull(getActivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (list != null) {
                            mTopicDetailsAdapter = new TopicDetailsAdapter(Objects.requireNonNull(getContext()), list);
                            mRcvTopicDetails.setAdapter(mTopicDetailsAdapter);
                            mRcvTopicDetails.setHasFixedSize(true);
                            mTopicDetailsAdapter.onItemClickListener(new TopicDetailsAdapter.ClickItemTopicDetails() {
                                @SuppressWarnings("deprecation")
                                @Override
                                public void onClickItem(final View view, int position) {
                                    final ValueAnimator value = ValueAnimator.ofFloat(1.3f, 1f);
                                    value.setDuration(600);
                                    value.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                        @Override
                                        public void onAnimationUpdate(ValueAnimator animation) {
                                            float progress = (float) value.getAnimatedValue();
                                            view.setScaleX(progress);
                                            view.setScaleY(progress);
                                        }
                                    });
                                    value.start();
                                    String tts = list.get(position).getName();
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


}


